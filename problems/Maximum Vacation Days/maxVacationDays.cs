public class Solution {
    public int MaxVacationDays(int[][] flights, int[][] days) {
        var memo = new int[flights.Length, days[0].Length];

        for (int i = 0; i < memo.GetLength(0); i++)
        {
            for (int j = 0; j < memo.GetLength(1); j++)
            {
                memo[i, j] = Int32.MinValue;
            }
        }

        return dfs(flights, days, 0, 0, memo);
    }

    public int dfs(int[][] flights, int[][] days, int cur_city, int weekno, int[,] memo) {
        if (weekno == days[0].Length)
            return 0;
        if (memo[cur_city, weekno] != Int32.MinValue)
            return memo[cur_city, weekno];

        int maxvac = 0;

        for (int i = 0; i < flights.Length; i++) {
            if (flights[cur_city][i] == 1 || i == cur_city) {
                int vac = days[i][weekno] + dfs(flights, days, i, weekno + 1, memo);
                maxvac = Math.Max(maxvac, vac);
            }
        }
        memo[cur_city, weekno] = maxvac;

        return maxvac;
    }
}
