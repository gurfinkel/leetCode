public class Solution {
    public int ShortestDistance(int[][] grid) {
        if (null == grid || 0 == grid.Length) {
            return -1;
        }

        var rows = grid.Length;
        var cols = grid[0].Length;

        // prepare helper arrays
        int[][] canReach = new int[rows][]; // how many buildings are reachable from this point
        int[][] dist = new int[rows][]; // shortest distances to building from this point
        for (int i = 0; i < rows; i++) {
            canReach[i] = new int[cols];
            dist[i] = new int[cols];
        }

        int totalBuildings = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // count total number of buildings
                    totalBuildings++;
                    // start from building
                    if (!bfs(grid, i, j, dist, canReach))
                        return -1;
                }
            }
        }

        // find empty space land with minimum distance to all buildings
        int minDis = int.MaxValue;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings && dist[i][j] < minDis)
                    minDis = dist[i][j];
            }
        }

        return minDis == int.MaxValue ? -1 : minDis;
    }

    private int[] rowDir = {1, -1, 0, 0};
    private int[] colDir = {0, 0, 1, -1};

    private bool bfs(int[][] grid, int row, int col, int[][] dist, int[][] canReach) {
        int rows = grid.Length;
        int cols = grid[0].Length;

        // prepare helper array to track visited grid cells
        bool[][] visited = new bool[rows][];
        for (int i = 0; i < rows; i++)
            visited[i] = new bool[cols];

        var q = new Queue<int[]>();
        // starting point
        q.Enqueue(new int[]{row, col});
        visited[row][col] = true;

        int d = 0;
        while (q.Count > 0) {
            d++;
            var nq = new Queue<int[]>();
            while (q.Count > 0) {
                int[] cur = q.Dequeue();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int rr = rowDir[k] + r;
                    int cc = colDir[k] + c;
                    if (!isValid(grid, rr, cc, visited))
                        continue;

                    // empty cell
                    if (grid[rr][cc] == 0) {
                        // update distance
                        dist[rr][cc] += d;

                        // can reach this building bfs (row, col)
                        canReach[rr][cc]++;

                        // explore further
                        nq.Enqueue(new int[]{rr, cc});
                    }

                    // mark as visited
                    visited[rr][cc] = true;
                }
            }
            q = nq;
        }

        // if not all building are reachable then there is no solution from these point (col, row)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1)
                    return false;
            }
        }

        return true;
    }

    private bool isValid(int[][] grid, int rr, int cc, bool[][] visited) {
        // valid cell should be in inside
        if (rr < 0 || rr >= grid.Length || cc < 0 || cc >= grid[0].Length)
            return false;

        // valid cell should be not visited
        if (visited[rr][cc])
            return false;

        // valid cell should not be obstacle
        if (grid[rr][cc] == 2)
            return false;

        return true;
    }
}
