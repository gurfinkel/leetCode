public class Solution {
    public void Rotate(int[][] matrix) {
        rotateClockwise(matrix);

        // // 90 degrees counter-clockwise
        // doAnotherTranspose(matrix);
        // doReverseRows(matrix);
        // // 90 degrees clockwise
        // doTranspose(matrix);
        // doReverseRows(matrix);
        // // 90 degrees clockwise
        // doTranspose(matrix);
        // doReverseRows(matrix);
    }

    private void rotateClockwise(int[][] matrix) {
        int n = matrix.Length;

        for (var i = 0; (n + 1) >> 1 > i; ++i) {
            for (var j = 0; n >> 1 > j; ++j) {

                // int temp = matrix[n - 1 - j][i];
                // matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                // matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                // matrix[j][n - 1 - i] = matrix[i][j];
                // matrix[i][j] = temp;

                var temp = new int[4];
                var row = i;
                var col = j;

                for (var k = 0; 4 > k; ++k) {
                    temp[k] = matrix[row][col];
                    var x = row;
                    row = col;
                    col = n - 1 - x;
                }

                for (var k = 0; 4 > k; ++k) {
                    matrix[row][col] = temp[(3 + k) % 4];
                    var x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    private void rotateCounterClockwise(int[][] matrix) {
        int n = matrix.Length;

        for (var i = 0; (n + 1) >> 1 > i; ++i) {
            for (var j = 0; n >> 1 > j; ++j) {
                var tmp = new int[4];
                var row = i;
                var col = j;

                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(1 + k) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    private void doTranspose(int[][] matrix) {
        var n = matrix.Length;

        for (var row = 0; n > row; ++row) {
            for (var col = row; n > col; ++col) {
                var tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }

    private void doAnotherTranspose(int[][] matrix) {
        var n = matrix.Length;

        for (var row = 0; n > row; ++row) {
            for (var col = 0; n - row > col; ++col) {
                var tmp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][n - 1 - row];
                matrix[n - 1 - col][n - 1 - row] = tmp;
            }
        }
    }

    private void doReverseRows(int[][] matrix) {
        var n = matrix.Length;

        for (var row = 0; n > row; ++row) {
            for (var col = 0; n >> 1 > col; ++col) {
                var tmp = matrix[row][col];
                matrix[row][col] = matrix[row][n - 1 - col];
                matrix[row][n - 1 - col] = tmp;
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        for (var i = 0; matrix.Length > i; ++i) {
            Console.WriteLine("[{0}]", string.Join(", ", matrix[i]));
        }
    }
}
