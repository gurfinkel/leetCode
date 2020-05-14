class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return new ArrayList<Integer>();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = 0;
        int idx = 0;
        int n = rows * cols;
        Integer[] result = new Integer[n];

        while (true) {
            for (int i = col; cols > i; ++i) {
                result[idx++] = matrix[row][i];
            }
            if (n == idx) {
                break;
            }
            ++row;
            for (int i = row; rows > i; ++i) {
                result[idx++] = matrix[i][cols - 1];
            }
            if (n == idx) {
                break;
            }
            --cols;
            for (int i = cols - 1; col <= i; --i) {
                result[idx++] = matrix[rows - 1][i];
            }
            if (n == idx) {
                break;
            }
            --rows;
            for (int i = rows - 1; row <= i; --i) {
                result[idx++] = matrix[i][col];
            }
            if (n == idx) {
                break;
            }
            ++col;
        }

        return Arrays.asList(result);
    }
}
