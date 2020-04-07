public class Solution {
    public bool HasPath(int[][] maze, int[] start, int[] destination) {
        if (null == maze || 0 == maze.Length) {
            return false;
        }

        var visited = new bool[maze.Length][];

        for (var i = 0; visited.Length > i; ++i) {
            visited[i] = new bool[maze[0].Length];
        }

        return dfs(maze, visited, start, destination);
    }

    private bool dfs(int[][] maze, bool[][] visited, int[] start, int[] destination) {
        if (visited[start[0]][start[1]]) {
            return false;
        }

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        visited[start[0]][start[1]] = true;

        // down
        var y = start[0];
        while (maze.Length > ++y && 0 == maze[y][start[1]]) {}

        if (dfs(maze, visited, new [] {y - 1, start[1]}, destination)) {
            return true;
        }
        // up
        y = start[0];
        while (0 <= --y && 0 == maze[y][start[1]]) {}

        if (dfs(maze, visited, new [] {y + 1, start[1]}, destination)) {
            return true;
        }
        // left
        var x = start[1];
        while (0 <= --x && 0 == maze[start[0]][x]) {}

        if (dfs(maze, visited, new [] {start[0], x + 1}, destination)) {
            return true;
        }
        // right
        x = start[1];
        while (maze[0].Length > ++x && 0 == maze[start[0]][x]) {}

        if (dfs(maze, visited, new [] {start[0], x - 1}, destination)) {
            return true;
        }

        return false;
    }
}
