/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if (1 === nums.length) {
        return nums[0];
    }

    const dpWithoutLast = Array(nums.length).fill(-1);
    const dpWithoutFirst = Array(nums.length).fill(-1);
    const numsWithoutFirst = nums.slice(1);
    nums.splice(-1, 1);

    const getMoney = function(items, dp, index = 0) {
        if (items.length <= index) {
            return 0;
        }

        if (!~dp[index]) {
            dp[index] = Math.max(items[index] + getMoney(items, dp, index + 2), getMoney(items, dp, index + 1));
        }

        return dp[index];
    }

    return Math.max(getMoney(nums, dpWithoutLast), getMoney(numsWithoutFirst, dpWithoutFirst));
};
