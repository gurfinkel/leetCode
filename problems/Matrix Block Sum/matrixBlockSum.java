class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] prefixSums = new int[1 + rows][1 + cols];
        int[][] result = new int[rows][cols];

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                prefixSums[1 + row][1 + col] = mat[row][col] + prefixSums[row][1 + col] + prefixSums[1 + row][col] - prefixSums[row][col];
            }
        }

        for (int row = 1; row < rows + 1; row++) {
            for (int col = 1; col < cols + 1; col++) {
                int left = Math.max(0, col - k - 1);
                int top = Math.max(0, row - k - 1);
                int right = Math.min(cols, col + k);
                int down = Math.min(rows, row + k);

                result[row - 1][col - 1] = prefixSums[down][right] - prefixSums[top][right] - prefixSums[down][left] + prefixSums[top][left];
            }
        }

        return result;
    }
}
