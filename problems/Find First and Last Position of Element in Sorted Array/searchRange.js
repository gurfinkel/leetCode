/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    const binarySearch = function(nums, target, leftmost) {
        let left = 0;
        let right = nums.length;
        
        while (left + 1 < right) {
            const mid = Math.floor((right + left) / 2);
            
            if (nums[mid] === target) {
                if (leftmost) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] === target) {
            return left;
        }
        if (nums.length > right && nums[right] === target) {
            return right;
        }
        
        return -1;
    };
    
    let left = binarySearch(nums, target, true);
    
    if (left < 0) return [-1, -1];
    
    let right = binarySearch(nums, target, false);
    
    return [left, right];
};
