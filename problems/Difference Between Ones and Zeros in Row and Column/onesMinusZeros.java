class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];
        int[] onesInCols = new int[cols];
        int[] onesInRows = new int[rows];
        int[] zerosInCols = new int[cols];
        int[] zerosInRows = new int[rows];

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (0 == grid[row][col]) {
                    ++zerosInCols[col];
                    ++zerosInRows[row];
                } else {
                    ++onesInCols[col];
                    ++onesInRows[row];
                }
            }
        }

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                result[row][col] = onesInRows[row] + onesInCols[col] - zerosInRows[row] - zerosInCols[col];
            }
        }

        return result;
    }
}
