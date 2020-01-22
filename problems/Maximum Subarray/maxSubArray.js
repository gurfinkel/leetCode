/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let max = Number.MIN_SAFE_INTEGER;
    let current = 0;

    for (const item of nums) {
        max = Math.max(max, current + item);
        current = Math.max(0, current + item);
    }

    return max;
};
