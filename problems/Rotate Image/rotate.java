class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; (n + 1) / 2 > i; ++i) { // 0, 0
            for (int j = 0; n / 2 > j; ++j) { // 0, 1
                int tmp = matrix[n - 1 - j][i]; // 7, 4
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // 9, 8
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // 3, 6
                matrix[j][n - 1 - i] = matrix[i][j]; // 1, 2
                matrix[i][j] = tmp; // 7, 4
            }
        }
    }
}
