class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];

        for (int i = 0; mat1.length > i; ++i) {
            for (int k = 0; mat1[0].length > k; ++k) {
                if (0 != mat1[i][k]) {
                    for (int j = 0; mat2[0].length > j; ++j) {
                        if (0 != mat2[k][j]) {
                            result[i][j] += mat1[i][k] * mat2[k][j];
                        }
                    }
                }
            }
        }

        return result;
    }
}
