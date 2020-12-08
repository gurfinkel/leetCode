class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int item = 1;
        int rows = n;
        int cols = n;
        int row = 0;
        int col = 0;

        while (n*n >= item) {
            for (int idx = col; cols > idx; ++idx) {
                result[row][idx] = item++;
            }

            ++row;

            if (n*n < item) {
                break;
            }

            for (int idx = row; rows > idx; ++idx) {
                result[idx][cols - 1] = item++;
            }

            --cols;

            if (n*n < item) {
                break;
            }

            for (int idx = cols - 1; col <= idx; --idx) {
                result[rows - 1][idx] = item++;
            }

            --rows;

            if (n*n < item) {
                break;
            }

            for (int idx = rows - 1; row <= idx; --idx) {
                result[idx][col] = item++;
            }

            ++col;
        }

        return result;
    }
}
