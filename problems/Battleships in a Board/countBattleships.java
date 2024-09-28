class Solution {
    public int countBattleships(char[][] board) {
        if (0 == board.length) {
            return 0;
        }

        int[][] directions = new int[][] {{-1,0},{0,-1}};
        int rows = board.length;
        int cols = board[0].length;
        int result = 0;

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if ('X' == board[row][col]) {
                    boolean flag = false;

                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if (0 <= newRow && rows > newRow && 0 <= newCol && cols > newCol && 'X' == board[newRow][newCol]) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        ++result;
                    }
                }
            }
        }

        return result;
    }
}
