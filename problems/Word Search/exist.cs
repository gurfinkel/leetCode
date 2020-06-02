public class Solution {
    public bool Exist(char[][] board, string word) {
        for (var i = 0; board.Length > i; ++i) {
            for (var j = 0; board[0].Length > j; ++j) {
                if (backtrack(board, word, new StringBuilder(), i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private bool backtrack(char[][] board, string word, StringBuilder sb, int i, int j, int idx = 0) {
        if (word.Length == idx) {
            return true;
        }

        var rows = board.Length;
        var cols = board[0].Length;

        if (0>i||0>j||rows<=i||cols<=j||word[idx]!=board[i][j]) {
            return false;
        }

        sb.Append(board[i][j]);
        board[i][j] = '$';

        var up = backtrack(board, word, sb, i - 1, j, 1 + idx);
        if (up) return true;
        var left = backtrack(board, word, sb, i, j - 1, 1 + idx);
        if (left) return true;
        var down = backtrack(board, word, sb, i + 1, j, 1 + idx);
        if (down) return true;
        var right = backtrack(board, word, sb, i, j + 1, 1 + idx);
        if (right) return true;

        board[i][j] = sb[sb.Length - 1];
        sb.Remove(sb.Length - 1, 1);

        return false;
    }
}
