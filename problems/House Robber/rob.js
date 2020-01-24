/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let currMax = 0;
    let prevMax = 0;

    for (const num of nums) {
        const temp = currMax;
        currMax = Math.max(prevMax + num, currMax);
        prevMax = temp;
    }

    return currMax;
};
