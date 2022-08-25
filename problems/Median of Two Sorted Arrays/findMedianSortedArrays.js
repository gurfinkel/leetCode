/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let m = nums1.length;
    let n = nums2.length;

    if (m > n) {
        const tmpArr = nums1; nums1 = nums2; nums2 = tmpArr;
        const tmpIdx = m; m = n; n = tmpIdx;
    }

    let iMin = 0;
    let iMax = m;
    let mid = Math.trunc((1 + m + n) / 2);

    while (iMin <= iMax) {
        let i = Math.trunc((iMin + iMax) / 2);
        let j = mid - i;

        if (iMax > i && nums1[i] < nums2[j - 1]){
            iMin = 1 + i; // i is too small
        } else if (iMin < i && nums1[i - 1] > nums2[j]) {
            iMax = i - 1; // i is too big
        } else {
            let maxLeft = 0;
            let minRight = 0;

            if (0 === i) {
                maxLeft = nums2[j - 1];
            } else if (0 === j) {
                maxLeft = nums1[i - 1];
            } else {
                maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
            }

            if (1 === (m + n) % 2) {
                return maxLeft;
            }

            if (m === i) {
                minRight = nums2[j];
            } else if (n === j) {
                minRight = nums1[i];
            } else {
                minRight = Math.min(nums1[i], nums2[j]);
            }

            return (maxLeft + minRight) / 2.0;
        }
    }
    return 0.0;
};
