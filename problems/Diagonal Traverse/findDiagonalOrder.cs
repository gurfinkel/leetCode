public class Solution {
    public int[] FindDiagonalOrder(int[][] matrix) {
        int n = matrix.Length;
        if (n == 0)
        {
            return new int[]{};
        }

        int m = matrix[0].Length;
        List<List<int>> diagonals = new List<List<int>>();

        for (int j = 0; j < m + n; j++)
        {
            int i = 0;
            int k = j;

            if (j >= m)
            {
                k = m - 1;
                i = j - m + 1;
            }

            diagonals.Add(new List<int>());
            while (i < n && k >= 0)
            {
                diagonals[diagonals.Count - 1].Add(matrix[i][k]);
                i++;
                k--;
            }
        }

        List<int> res = new List<int>(n*m);

        for (int i = 0; i < diagonals.Count; i++)
        {
            if (i % 2 == 0)
            {
                diagonals[i].Reverse();
            }
            res.AddRange(diagonals[i]);
        }

        return res.ToArray();
    }
}
