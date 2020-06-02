public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        var grid = new bool[numCourses, numCourses];
        var colours = new int[numCourses];

        foreach (var item in prerequisites) {
            grid[item[1], item[0]] = true;
        }

        for (var i = 0; numCourses > i; ++i) {
            for (var j = 0; numCourses > j; ++j) {
                if (grid[i, j] && 0 == colours[j] && !dfs(grid, colours, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private bool dfs(bool[,] grid, int[] colours, int idx = 0) {
        colours[idx] = 1;

        for (var i = 0; colours.Length > i; ++i) {
            if (grid[idx, i]) {
                if (1 == colours[i] || (0 == colours[i] && !dfs(grid, colours, i))) {
                    return false;
                }
            }
        }

        colours[idx] = 2;

        return true;
    }
}
