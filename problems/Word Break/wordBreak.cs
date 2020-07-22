public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        return wordBreakBottomUp(s, new HashSet<string>(wordDict));
    }

    private bool wordBreakBottomUp(string s, HashSet<string> store) {
        int n = s.Length;
        bool[] dp = new bool[1 + n];

        dp[0] = true;

        for (int i = 1; n >= i; ++i) {
            for (int j = 0; i > j; ++j) {
                if (dp[j] && store.Contains(s.Substring(j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
