public class Solution {
    public int[][] Multiply(int[][] A, int[][] B) {
        int n = A.Length;
        int m = B[0].Length;

        var res = new int[n][];

        for (int i = 0; i < n; i++)
        {
            res[i] = new int[m];
        }


        ISet<int>[] bColNonZeroes = new ISet<int>[m];
        for (int i = 0; i < m; i++)
        {
            bColNonZeroes[i] = new HashSet<int>(B.Length);

            for (int j = 0; j < B.Length; j++)
            {
                if (B[j][i] != 0)
                {
                    bColNonZeroes[i].Add(j);
                }
            }
        }



        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < A[i].Length; k++)
                {
                    if (A[i][k] != 0 && bColNonZeroes[j].Contains(k))
                    {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

        }

        return res;
    }
}
