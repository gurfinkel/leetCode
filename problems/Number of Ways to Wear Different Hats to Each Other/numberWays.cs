public class Solution {
    public int NumberWays(IList<IList<int>> hats) {
        return NumberWaysDp(hats);
    }

    private int NumberWaysDp(IList<IList<int>> hats) {
        var n = hats.Count;
        var cw = new bool[n, 41];
        var dp = new int[41, 1 << n];

        for (var i = 0; i < n; ++i) {
            foreach (var h in hats[i]) {
                cw[i, h] = true;
            }
        }

        dp[0, 0] = 1;

        for (var i = 1; i <= 40; ++i) {
            for (var j = 0; j < (1 << n); ++j) {
                dp[i, j] = dp[i - 1, j];
            }
            for (var j = 0; j < (1 << n); ++j) {
                for (var k = 0; k < n; ++k) {
                    var j2 = j | (1 << k);

                    if (j2==j)
                        continue;
                    if (!cw[k, i])
                        continue;

                    dp[i, j2] += dp[i-1, j];
                    dp[i, j2] %= 1000000007;
                }
            }
        }

        return dp[40, (1 << n) - 1];
    }

    public int NumberWaysBacktrack(IList<IList<int>> hats) {
        var result = 0;
        var visited = new int[40];

        backtrack(hats, visited, ref result);

        return result;
    }

    private void backtrack(IList<IList<int>> hats, int[] visited, ref int result, int idx = 0) {
        if (hats.Count - 1 == idx) {
            foreach (var hat in hats[idx]) {
                if (0 == visited[hat - 1]) {
                    result = (result + 1) % 1000000007;
                }
            }
        } else {
            foreach (var hat in hats[idx]) {
                if (0 == visited[hat - 1]) {
                    ++visited[hat - 1];
                    backtrack(hats, visited, ref result, 1 + idx);
                    --visited[hat - 1];
                }
            }
        }
    }
}
