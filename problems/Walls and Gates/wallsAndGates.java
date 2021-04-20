class Solution {
    public void wallsAndGates(int[][] rooms) {
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;
        List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
        );

        int rows = rooms.length;
        if (0 == rows) {
            return;
        }
        int cols = rooms[0].length;
        Queue<int[]> bfs = new LinkedList<>();

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (GATE == rooms[row][col]) {
                    bfs.add(new int[] { row, col });
                }
            }
        }

        while (!bfs.isEmpty()) {
            int[] point = bfs.poll();
            int row = point[0];
            int col = point[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (0 > newRow || 0 > newCol || rows <= newRow || cols <= newCol || EMPTY != rooms[newRow][newCol]) {
                    continue;
                }

                rooms[newRow][newCol] = 1 + rooms[row][col];
                bfs.add(new int[] { newRow, newCol });
            }
        }
    }
}
