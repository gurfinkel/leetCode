public class Solution {
    public int OrangesRotting(int[][] grid) {
        int freshOranges = 0;
        int minutesElapsed = -1;
        Queue<int[]> bfs = new Queue<int[]>();
        List<int[]> directions = new List<int[]> {
            new [] {-1, 0}, new [] {1, 0}, new [] {0, 1}, new [] {0, -1}
        };
        int rows = grid.Length;
        int cols = grid[0].Length;

        for (int r = 0; rows > r; ++r) {
            for (int c = 0; cols > c; ++c) {
                if (2 == grid[r][c]) {
                    bfs.Enqueue(new [] {r, c});
                } else if (1 == grid[r][c]) {
                    ++freshOranges;
                }
            }
        }

        bfs.Enqueue(null);

        while (0 < bfs.Count) {
            var p = bfs.Dequeue();

            if (null == p) {
                ++minutesElapsed;

                if (0 < bfs.Count) {
                    bfs.Enqueue(null);
                }
            } else {
                int row = p[0];
                int col = p[1];

                foreach (var direction in directions) {
                    int neighborRow = row + direction[0];
                    int neighborCol = col + direction[1];

                    if (0 <= neighborRow && rows > neighborRow &&
                       0 <= neighborCol && cols > neighborCol) {
                        if (1 == grid[neighborRow][neighborCol]) {
                            grid[neighborRow][neighborCol] = 2;
                            --freshOranges;
                            bfs.Enqueue(new [] {neighborRow, neighborCol});
                        }
                    }
                }
            }
        }

        return 0 == freshOranges ? minutesElapsed : -1;
    }
}
