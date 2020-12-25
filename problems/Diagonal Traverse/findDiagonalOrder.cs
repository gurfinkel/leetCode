public class Solution {
    public int[] FindDiagonalOrder(int[][] matrix) {
        if (0 == matrix.Length) {
            return new int[]{};
        }

        int rows = matrix.Length;
        int cols = matrix[0].Length;
        List<List<int>> diagonals = new List<List<int>>();
        List<int> result = new List<int>(rows * cols);

        for (int j = 0; rows + cols > j; ++j) {
            int i = 0;
            int k = j;

            if (cols <= j) {
                k = cols - 1;
                i = 1 + j - cols;
            }

            diagonals.Add(new List<int>());

            while (rows > i && 0 <= k) {
                diagonals[diagonals.Count - 1].Add(matrix[i++][k--]);
            }
        }

        for (int i = 0; diagonals.Count > i; ++i) {
            if (0 == (i & 1)) {
                diagonals[i].Reverse();
            }
            result.AddRange(diagonals[i]);
        }

        return result.ToArray();
    }
}
