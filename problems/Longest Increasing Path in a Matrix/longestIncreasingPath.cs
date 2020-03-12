public class Solution {
    public int LongestIncreasingPath(int[][] matrix) {
        int n = matrix.Length;
        if (n == 0)
        {
            return 0;
        }

        int m = matrix[0].Length;
        int?[,] cache = new int?[n,m];

        int res = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                res = Math.Max(res, DFS(matrix, cache, i, j));
            }
        }

        return res;
    }

    private static (int, int)[] _directions = { (0,1), (0,-1), (1,0), (-1,0) };

    private int DFS(int[][] matrix, int?[,] cache, int i, int j)
    {
        int n = cache.GetLength(0);
        int m = cache.GetLength(1);

        if (cache[i, j].HasValue)
        {
            return cache[i, j].Value;
        }

        int res = 1;

        foreach (var direction in _directions)
        {
            int newI = i + direction.Item1;
            int newJ = j + direction.Item2;

            if (newJ < 0 || newJ >= m)
            {
                continue;
            }

            if (newI < 0 || newI >= n)
            {
                continue;
            }

            if (matrix[i][j] >= matrix[newI][newJ])
            {
                continue;
            }

            res = Math.Max(res, DFS(matrix, cache, newI, newJ) + 1);

        }


        cache[i, j] = res;
        return res;
    }
}
