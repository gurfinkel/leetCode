public class Solution {
    public int[][] FlipAndInvertImage(int[][] A) {
        int rows = A.Length;
        int cols = A[0].Length;

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; (cols >> 1) > col; ++col) {
                int temp = (1 == A[row][col] ? 0 : 1);
                A[row][col] = (1 == A[row][cols - col - 1] ? 0 : 1);
                A[row][cols - col - 1] = temp;
            }

            if (1 == (cols & 1)) {
                A[row][cols >> 1] = (1 == A[row][cols >> 1] ? 0 : 1);
            }
        }

        return A;
    }
}
