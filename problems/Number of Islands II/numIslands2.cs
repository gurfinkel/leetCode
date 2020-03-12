public class Solution {
    public IList<int> NumIslands2(int m, int n, int[][] positions) {
        bool[,] grid = new bool[m,n];
        IList<int> res = new List<int>(positions.Length);
        ISet<int> roots = new HashSet<int>();
        Unions dsu = new Unions(m*n);

        IList<int> removeRoots = new List<int>();

        for (int i = 0; i < positions.Length; i++)
        {
            var pos = positions[i];
            if (grid[pos[0], pos[1]])
            {
                res.Add(roots.Count);
                continue;
            }


            grid[pos[0], pos[1]] = true;
            var posLinear = n * pos[0] + pos[1];
            removeRoots.Clear();

            foreach (var dir in _directions)
            {
                int newI = pos[0] + dir.di;
                int newJ = pos[1] + dir.dj;
                int linear = newI * n + newJ;

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI, newJ])
                {
                    removeRoots.Add(dsu.Find(linear));
                }
            }

            foreach (var dir in _directions)
            {
                int newI = pos[0] + dir.di;
                int newJ = pos[1] + dir.dj;
                int linear = newI * n + newJ;

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI, newJ])
                {
                    dsu.Union(posLinear, linear);
                }
            }

            foreach (var removeRoot in removeRoots)
            {
                roots.Remove(removeRoot);
            }

            roots.Add(dsu.Find(posLinear));

            res.Add(roots.Count);
        }

        return res;
    }

    private static readonly (int di, int dj)[] _directions = {(0, 1), (0, -1), (1, 0), (-1, 0)};

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
