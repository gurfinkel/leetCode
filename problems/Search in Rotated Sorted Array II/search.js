/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
    const store = new Set(nums);
    const numsWithoutDuplicates = Array.from(store);

    let left = 0;
    let right = numsWithoutDuplicates.length - 1;

    while (left <= right) {
        let mid = ~~((left+right) >> 1);

        if (target === numsWithoutDuplicates[mid]) {
            return true;
        }

        if (numsWithoutDuplicates[left] <= numsWithoutDuplicates[mid]) {
            if (target >= numsWithoutDuplicates[left] && target <= numsWithoutDuplicates[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (target >= numsWithoutDuplicates[mid] && target <= numsWithoutDuplicates[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    return false;
};
