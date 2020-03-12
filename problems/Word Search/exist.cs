public class Solution {
    public bool Exist(char[][] board, string word) {
        if (board.Length == 0)
        {
            return false;
        }

        int n = board.Length;
        int m = board[0].Length;

        bool[,] visited = new bool[n, m];

        if (word.Length == 0)
        {
            return false;
        }

        for (int i = 0; i < board.Length; i++)
        {
            for (int j = 0; j < board[i].Length; j++)
            {
                if (board[i][j] == word[0])
                {
                    if (Helper(board, visited, ref word, 0, (i, j)))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static readonly (int, int)[] _directions = { (1, 0), (-1, 0), (0, 1), (0, -1) };

    private bool Helper(char[][] board, bool[,] visited, ref string word, int charIdx, (int, int) cell)
    {
        if (charIdx == word.Length - 1)
        {
            return true;
        }

        visited[cell.Item1, cell.Item2] = true;

        foreach (var direction in _directions)
        {
            (int, int) newCell = (cell.Item1 + direction.Item1, cell.Item2 + direction.Item2);
            if (newCell.Item1 >= 0 && newCell.Item1 < board.Length && newCell.Item2 >= 0 &&
                newCell.Item2 < board[newCell.Item1].Length)
            {
                if (board[newCell.Item1][newCell.Item2] == word[charIdx + 1] && !visited[newCell.Item1, newCell.Item2])
                {
                    if (Helper(board, visited, ref word, charIdx + 1, newCell))
                    {
                        return true;
                    }
                }
            }
        }

        visited[cell.Item1, cell.Item2] = false;

        return false;
    }
}
