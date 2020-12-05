/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
    if (!nums || !nums.length) {
        return 0;
    }

    let result = 0;
    let anchor = 0;

    for (let i = 0; i in nums; ++i) {
        if (i && nums[i - 1] >= nums[i]) {
            anchor = i;
        }
        
        result = Math.max(result, i - anchor + 1);
    }

    return result;
};
