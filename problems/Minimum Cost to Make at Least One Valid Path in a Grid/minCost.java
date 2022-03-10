class Solution {
    public int minCost(int[][] grid) {
        int[][] DIRS = {{0, 1},{0, -1},{1, 0},{-1, 0},};
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] costs = new int[grid.length][grid[0].length];

        for (int[] row: costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        queue.add(new int[]{0, 0});
        // TODO: initialize the initialize cost to be zero
        costs[0][0] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();

                for (int i = 0; i < DIRS.length; i++) {
                    int[] dir = DIRS[i];
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];

                    if (!isValid(grid, r, c)) {
                        continue;
                    }

                    // TODO: check if the direction aligns with testing cell costs[r][c]
                    int extraCost = 0;
                    if (grid[cell[0]][cell[1]] != i + 1) {
                        extraCost = 1;
                    }

                    // TODO: only continue and update if the new cost is lower
                    int newCost = costs[cell[0]][cell[1]] + extraCost;

                    if (newCost >= costs[r][c]) {
                        continue;
                    }

                    costs[r][c] = newCost;

                    // TODO: give lower cost path higher priority
                    if (extraCost == 0) {
                        queue.addFirst(new int[]{r, c});
                    } else {
                        queue.addLast(new int[]{r, c});
                    }
                }
            }
        }
        return costs[grid.length - 1][grid[0].length - 1];
    }

    boolean isValid(int[][] grid, int row, int col) {
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length);
    }
}
