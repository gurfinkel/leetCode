/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    const rows = word1.length;
    const cols = word2.length;
    const dp = Array(1 + rows).fill([]).map(_ => Array(1 + cols).fill(0));

    dp[0] = [...Array(1 + cols).keys()];

    for (let j = 1; rows >= j; ++j) {
        dp[j][0] = j;
    }

    for (let i = 1; rows >= i; ++i) {
        for (let j = 1; cols >= j; ++j) {
            if (word1[i - 1] === word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + Math.min(
                    dp[i - 1][j], // Delete a character
                    dp[i - 1][j - 1], // Replace a character
                    dp[i][j - 1] // Insert a character
                );
            }
        }
    }

    return dp[rows][cols];
};
