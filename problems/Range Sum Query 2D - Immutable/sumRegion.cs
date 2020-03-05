public class NumMatrix {

    private int[][] store;
    private bool isEmpty = true;

    public NumMatrix(int[][] matrix) {
        var rows = matrix.Length;

        if (0 < rows) {
            var cols = matrix[0].Length;
            store = new int[rows][];

            for (var row = 0; rows > row; ++row) {
                store[row] = new int[1 + cols];
                for (var col = 1; cols >= col; ++col) {
                    store[row][col] = store[row][col - 1] + matrix[row][col - 1];
                }
                // Console.WriteLine("[{0}]", string.Join(", ", store[row]));
            }

            isEmpty = false;
        }
    }

    public int SumRegion(int row1, int col1, int row2, int col2) {
        if (isEmpty) {
            return 0;
        }

        var result = 0;
        for (var row = row1; row2 >= row; ++row) {
            result += store[row][col2 + 1] - store[row][col1];
        }

        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.SumRegion(row1,col1,row2,col2);
 */
