public class Solution {
    public int CountComponents(int n, int[][] edges) {
        Unions dsu = new Unions(n);

        foreach (var edge in edges)
        {
            dsu.Union(edge[0], edge[1]);
        }

        ISet<int> roots = new HashSet<int>();
        for (int i = 0; i < n; i++)
        {
            roots.Add(dsu.Find(i));
        }

        return roots.Count;
    }

    private class Unions
    {
        private readonly int[] _parents;
        private readonly int[] _ranks;

        public Unions(int n)
        {
            _parents = new int[n];
            _ranks = new int[n];
            for (int i = 0; i < n; i++)
            {
                _parents[i] = i;
            }
        }

        public int Find(int x)
        {
            if (x != _parents[x])
            {
                x = Find(_parents[x]);
            }
            return _parents[x];
        }

        public bool Union(int x, int y)
        {
            int px = Find(x);
            int py = Find(y);
            if (px == py)
            {
                return false;
            }
            if (_ranks[px] > _ranks[py])
            {
                _parents[py] = px;
                _ranks[px]++;
            }
            else
            {
                _parents[px] = py;
                _ranks[py]++;
            }
            return true;
        }
    }
}
