/**
 * @param {string} s
 * @return {number}
 */
var minFlipsMonoIncr = function(s) {
    const n = s.length;
    const prefixSums = [0];
    let result = Number.MAX_SAFE_INTEGER;

    for (let idx = 0; n > idx; ++idx) {
        prefixSums.push(prefixSums[idx] + ('1' === s.charAt(idx) ? 1 : 0));
    }

    for (let idx = 0; n >= idx; ++idx) {
        const oneOnLeft = prefixSums[idx];
        const zeroOnRight = n - idx - (prefixSums[n] - prefixSums[idx]);

        result = Math.min(result, oneOnLeft + zeroOnRight);
    }

    return result;
};
