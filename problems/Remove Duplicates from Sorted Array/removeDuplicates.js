/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let lastIdx = 0;

    for (let idx = 1; nums.length > idx; ++idx) {
        if (nums[idx] !== nums[lastIdx]) {
            nums[++lastIdx] = nums[idx];
        }
    }

    return 1 + lastIdx;
};
