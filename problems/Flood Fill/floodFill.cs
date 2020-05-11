public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {
        var rows = image.Length;
        var cols = image[0].Length;
        var visited = new bool[rows * cols];
        var oldColor = image[sr][sc];

        dfs(image, visited, newColor, oldColor, sr, sc);

        return image;
    }

    private void dfs(int[][] image, bool[] visited, int newColor, int oldColor, int row, int col) {
        var rows = image.Length;
        var cols = image[0].Length;

        visited[cols * row + col] = true;
        image[row][col] = newColor;

        if (0 < row && !visited[cols * (row - 1) + col] && oldColor == image[row - 1][col]) {
            dfs(image, visited, newColor, oldColor, row - 1, col);
        }
        if (0 < col && !visited[cols * row + col - 1] && oldColor == image[row][col - 1]) {
            dfs(image, visited, newColor, oldColor, row, col - 1);
        }
        if (rows > 1 + row && !visited[cols * (1 + row) + col] && oldColor == image[1 + row][col]) {
            dfs(image, visited, newColor, oldColor, 1 + row, col);
        }
        if (cols > 1 + col && !visited[cols * row + col + 1] && oldColor == image[row][1 + col]) {
            dfs(image, visited, newColor, oldColor, row, 1 + col);
        }
    }
}
