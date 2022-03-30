public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        if (0 == matrix.Length) {
            return false;
        }

        int m = matrix.Length;
        int n = matrix[0].Length;

        var left = 0;
        var right = m * n - 1;

        while (left <= right) {
            var pivotIdx = (left + right) / 2;
            var pivotElement = matrix[pivotIdx / n][pivotIdx % n];

            if (target == pivotElement) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }
}
