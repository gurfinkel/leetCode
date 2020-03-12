public class Solution {
    public int CountBattleships(char[][] board) {
        (int dx, int dy)[] _directions = {(0,-1), (-1,0)};

        int n = board.Length;

        if (n == 0)
        {
            return 0;
        }

        int m = board[0].Length;

        int res = 0;


        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == 'X')
                {
                    bool adj = false;

                    foreach (var dir in _directions)
                    {
                        int newI = i + dir.dx;
                        int newJ = j + dir.dy;

                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && board[newI][newJ] == 'X')
                        {
                            adj = true;
                            break;
                        }
                    }

                    if (!adj)
                    {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
