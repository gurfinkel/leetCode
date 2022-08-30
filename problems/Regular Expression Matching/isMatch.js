/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    const tLen = s.length;
    const pLen = p.length;
    const dp = Array(1 + tLen).fill([]).map(_ => Array(1 + pLen).fill(false));

    dp[tLen][pLen] = true;

    for (let tIdx = tLen; 0 <= tIdx; --tIdx) {
        for (let pIdx = pLen - 1; 0 <= pIdx; --pIdx) {
            const currMatch = tLen > tIdx && (s.charAt(tIdx) === p.charAt(pIdx) || '.' === p.charAt(pIdx));
            if (pLen > 1 + pIdx && '*' === p.charAt(1 + pIdx)) {
                dp[tIdx][pIdx] = dp[tIdx][2 + pIdx] || (currMatch && dp[1 + tIdx][pIdx]);
            } else {
                dp[tIdx][pIdx] = currMatch && dp[1 + tIdx][1 + pIdx];
            }
        }
    }

    return dp[0][0];
};
