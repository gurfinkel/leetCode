class TicTacToe {

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        _n = n;
        _rows = new int[n];
        _cols = new int[n];
        _diagonalFromLeft = 0;
        _diagonalFromRight = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int play = 1 == player ? 1 : -1;

        _rows[row] += play;
        _cols[col] += play;

        if (row == col) {
            _diagonalFromLeft += play;
        }

        if (_n - 1 == row + col) {
            _diagonalFromRight += play;
        }

        if (Math.abs(_rows[row]) == _n || Math.abs(_cols[col]) == _n || Math.abs(_diagonalFromLeft) == _n || Math.abs(_diagonalFromRight) == _n)
            return player;

        return 0;
    }

    private int [] _rows;
    private int [] _cols;
    private int _diagonalFromLeft;
    private int _diagonalFromRight;
    private int _n;
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
