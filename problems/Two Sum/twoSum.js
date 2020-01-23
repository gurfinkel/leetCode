/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const store = new Map();

    for (let i = 0; nums.length > i; ++i) {
        if (store.has(target - nums[i])) {
            return [store.get(target - nums[i]), i];
        } else {
            store.set(nums[i], i);
        }
    }
};
