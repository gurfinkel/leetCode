class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        for (String row: board) {
            for (char symbol: row.toCharArray()) {
                if ('X' == symbol) {
                    ++xCount;
                }
                if ('O' == symbol) {
                    ++oCount;
                }
            }
        }

        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }

        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }

        if (win(board, 'O') && oCount != xCount) {
            return false;
        }

        return true;
    }

    public boolean win(String[] board, char symbol) {
        for (int idx = 0; 3 > idx; ++idx) {
            if (symbol == board[0].charAt(idx) && symbol == board[1].charAt(idx) && symbol == board[2].charAt(idx)) {
                return true;
            }

            if (symbol == board[idx].charAt(0) && symbol == board[idx].charAt(1) && symbol == board[idx].charAt(2)) {
                return true;
            }
        }

        if (symbol == board[0].charAt(0) && symbol == board[1].charAt(1) && symbol == board[2].charAt(2)) {
            return true;
        }

        if (symbol == board[0].charAt(2) && symbol == board[1].charAt(1) && symbol == board[2].charAt(0)) {
            return true;
        }

        return false;
    }
}
