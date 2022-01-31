class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 1; matrix.length > row; ++row) {
            for (int col = 1; matrix[row].length > col; ++col) {
                if (matrix[row - 1][col - 1] != matrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
