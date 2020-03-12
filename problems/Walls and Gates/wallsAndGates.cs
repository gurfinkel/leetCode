public class Solution {
    public void WallsAndGates(int[][] rooms) {
        int n = rooms.Length;
        if (n == 0)
        {
            return;
        }

        int m = rooms[0].Length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (rooms[i][j] == 0)
                {
                    Helper(rooms, i,j);
                }
            }
        }
    }

    private static readonly (int, int)[] _directions = {(0, 1), (0, -1), (1, 0), (-1, 0)};

    private void Helper(int[][] rooms, int i, int j)
    {
        int n = rooms.Length;
        int m = rooms[0].Length;

        Queue<(int, int)> bfs = new Queue<(int, int)>();
        bfs.Enqueue((i, j));

        int path = 0;
        while (bfs.Count != 0)
        {
            int count = bfs.Count;
            for (int k = 0; k < count; k++)
            {
                var cell = bfs.Dequeue();

                if (path > rooms[cell.Item1][cell.Item2])
                {
                    continue;
                }

                rooms[cell.Item1][cell.Item2] = path;

                foreach (var dir in _directions)
                {
                    int nextI = cell.Item1 + dir.Item1;
                    int nextJ = cell.Item2 + dir.Item2;

                    if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m)
                    {
                        bfs.Enqueue((nextI, nextJ));
                    }
                }
            }

            path++;
        }
    }
}
