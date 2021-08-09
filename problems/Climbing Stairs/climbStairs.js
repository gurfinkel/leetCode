/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    const dp = [1, 2];

    for (let idx = 2; n > idx; ++idx) {
        dp[idx] = dp[idx - 1] + dp[idx - 2];
    }

    return dp[n - 1];
};
