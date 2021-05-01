class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] grid = new ArrayList[numCourses];
        int[] colours = new int[numCourses];

        for (int[] item : prerequisites) {
            if (null == grid[item[1]]) {
                grid[item[1]] = new ArrayList<>();
            }

            grid[item[1]].add(item[0]);
        }

        for (int idx = 0; numCourses > idx; ++idx) {
            if (!dfs(grid, colours, idx)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(List<Integer>[] grid, int[] colours, int idx) {
        colours[idx] = 1;

        if (null != grid[idx]) {
            for (int item : grid[idx]) {
                if (1 == colours[item] || (0 == colours[item] && !dfs(grid, colours, item))) {
                    return false;
                }
            }
        }

        colours[idx] = 2;

        return true;
    }
}
