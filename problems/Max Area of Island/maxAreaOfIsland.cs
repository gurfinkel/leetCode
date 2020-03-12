public class Solution {
    public int MaxAreaOfIsland(int[][] grid) {
        int m = grid.Length, n = grid[0].Length;
        var visitedSet = new HashSet<(int, int)>();
        int maxArea = 0;

        for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (grid[i][j] == 1 && !visitedSet.Contains((i, j)))
                maxArea = Math.Max(maxArea, Dfs(grid, m, n, i, j, visitedSet));

        return maxArea;
    }

    int Dfs(int[][] grid, int m, int n, int row, int col, HashSet<(int, int)> visitedSet, int count = 1)
    {
        if (row >= m || row < 0 || col < 0 || col >= n || grid[row][col] == 0 ||
            visitedSet.Contains((row, col)))
            return 0;
        visitedSet.Add((row, col));
        count += Dfs(grid, m, n, row + 1, col, visitedSet);
        count += Dfs(grid, m, n, row - 1, col, visitedSet);
        count += Dfs(grid, m, n, row, col - 1, visitedSet);
        count += Dfs(grid, m, n, row, col + 1, visitedSet);

        return count;
    }
}
