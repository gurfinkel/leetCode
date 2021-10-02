class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;

        if (length > m*n || length < m*n) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];

        for (int i = 0; m > i; ++i) {
            for (int j = 0; n > j; ++j) {
                result[i][j] = original[n*i+j];
            }
        }

        return result;
    }
}
