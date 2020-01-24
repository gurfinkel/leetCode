/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    let endIndex = nums1.length - 1;

    while (0 <= m && 0 < n) {
        if (nums1[m - 1] > nums2[n - 1]) {
            nums1[endIndex--] = nums1[m - 1];
            nums1[endIndex] = Number.MIN_SAFE_INTEGER;
            --m;
        } else {
            nums1[endIndex--] = nums2[n - 1];
            --n;
        }
    }

    return nums1;
};
