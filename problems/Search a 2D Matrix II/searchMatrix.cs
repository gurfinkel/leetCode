public class Solution {
    public bool SearchMatrix(int[,] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.GetLength(0) - 1;
        int col = 0;

        while (row >= 0 && col < matrix.GetLength(1)) {
            if (matrix[row, col] > target) {
                row--;
            } else if (matrix[row, col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}
