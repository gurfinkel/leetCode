/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function(n) {
    return 0 === (Math.log10(n) / Math.log10(3)) % 1;
};
