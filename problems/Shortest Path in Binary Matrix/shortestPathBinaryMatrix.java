class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();

        if (0 == grid[0][0]) {
            grid[0][0] = 1;
            bfs.add(new int[]{0, 0});
        }

        while (!bfs.isEmpty()) {
            int[] cell = bfs.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];

            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }

            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];

                bfs.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }

        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (0 > newRow || 0 > newCol || newRow >= rows || newCol >= cols
                    || 0 != grid[newRow][newCol]) {
                continue;
            }

            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

    private int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
}
