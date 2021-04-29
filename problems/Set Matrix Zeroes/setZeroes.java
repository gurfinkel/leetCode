class Solution {
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; rows > i; ++i) {
            if (0 == matrix[i][0]) {
                isCol = true;
            }

            for (int j = 1; cols > j; ++j) {
                if (0 == matrix[i][j]) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; rows > i; ++i) {
            for (int j = 1; cols > j; ++j) {
                if (0 == matrix[i][0] || 0 == matrix[0][j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (0 == matrix[0][0]) {
            for (int j = 0; cols > j; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; rows > i; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
