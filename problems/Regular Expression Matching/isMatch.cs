public class Solution {
    public bool IsMatch(string s, string p) {
        if (string.IsNullOrEmpty(p)) {
            return string.IsNullOrEmpty(s);
        }

        var dp = new bool[1 + s.Length, 1 + p.Length];

        dp[0, 0] = true;

        for (var i = 1; p.Length > i; ++i) {
            if ('*' == p[i] && dp[0, i - 1]) {
                dp[0, 1 + i] = true;
            }
        }

        for (var i = 0; s.Length > i; ++i) {
            for (var j = 0; p.Length > j; ++j) {
                if (s[i] == p[j] || '.' == p[j]) {
                    dp[1 + i, 1 + j] = dp[i, j];
                } else if ('*' == p[j]) {
                    dp[1 + i, 1 + j] = dp[1 + i, j - 1] || (s[i] == p[j - 1] || p[j - 1] == '.') && dp[i, 1 + j];
                }
            }
        }

        return dp[s.Length, p.Length];
    }
}
