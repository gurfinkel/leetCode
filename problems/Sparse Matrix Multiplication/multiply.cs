public class Solution {
    public int[][] Multiply(int[][] A, int[][] B) {
        int n = A.Length;
        int m = B[0].Length;

        var res = new int[n][];

        for (int i = 0; i < n; i++) {
            res[i] = new int[m];
            for (int j = 0; j < m; j++){
                for (int k = 0; k < B.Length; k++){
                    if (A[i][k] != 0) {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

        }

        return res;
    }
}
