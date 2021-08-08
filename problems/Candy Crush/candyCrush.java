class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean isFinished = true;

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > 2 + col; ++col) {
                int val = Math.abs(board[row][col]);

                if (0 != val && Math.abs(board[row][1 + col]) == val && Math.abs(board[row][2 + col]) == val) {
                    board[row][col] = board[row][1 + col] = board[row][2 + col] = -val;
                    isFinished = false;
                }
            }
        }

        for (int row = 0; rows > 2 + row; ++row) {
            for (int col = 0; cols > col; ++col) {
                int val = Math.abs(board[row][col]);

                if (0 != val && Math.abs(board[1 + row][col]) == val && Math.abs(board[2 + row][col]) == val) {
                    board[row][col] = board[1 + row][col] = board[2 + row][col] = -val;
                    isFinished = false;
                }
            }
        }

        for (int col = 0; cols > col; ++col) {
            int idx = rows - 1;

            for (int row = rows - 1; 0 <= row; --row) {
                if (0 < board[row][col]) {
                    board[idx][col] = board[row][col];

                    if (idx-- != row) {
                        board[row][col] = 0;
                    }
                } else {
                    board[row][col] = 0;
                }
            }
        }

        return isFinished ? board : candyCrush(board);
    }
}
