class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArraysBs(nums1, nums2);
        // return findMedianSortedArraysMergeSort(nums1, nums2);
    }

    private double findMedianSortedArraysMergeSort(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (m > idx1 || n > idx2) {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;

            if (m > idx1) {
                num1 = nums1[idx1];
            }
            if (n > idx2) {
                num2 = nums2[idx2];
            }

            if (num1 < num2) {
                result[idx] = num1;
                ++idx1;
            } else {
                result[idx] = num2;
                ++idx2;
            }

            ++idx;
        }

        if (0 == (m + n)%2) {
            return 0.5*result[(m + n)/2 - 1] + 0.5*result[(m + n)/2];
        } else {
            return result[(m + n)/2];
        }
    }

    private double findMedianSortedArraysBs(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;

        if (1 == (length) % 2) {
            return getMedian(nums1, nums2, length / 2, 0, m - 1, 0, n - 1);
        } else {
            return 0.5*getMedian(nums1, nums2, length / 2, 0, m - 1, 0, n - 1) +
                0.5*getMedian(nums1, nums2, length / 2 - 1, 0, m - 1, 0, n - 1);
        }
    }

    public int getMedian(int[] nums1, int[] nums2, int k, int start1, int end1, int start2, int end2
    ) {
        if (end1 < start1) {
            return nums2[k - start1];
        }
        if (end2 < start2) {
            return nums1[k - start2];
        }

        int idx1 = (start1 + end1) / 2;
        int idx2 = (start2 + end2) / 2;
        int value1 = nums1[idx1];
        int value2 = nums2[idx2];

        if (k > idx1 + idx2) {
            if (value1 > value2) {
                return getMedian(nums1, nums2, k, start1, end1, 1 + idx2, end2);
            } else {
                return getMedian(nums1, nums2, k, 1 + idx1, end1, start2, end2);
            }
        } else {
            if (value1 > value2) {
                return getMedian(nums1, nums2, k, start1, idx1 - 1, start2, end2);
            } else {
                return getMedian(nums1, nums2, k, start1, end1, start2, idx2 - 1);
            }
        }
    }
}
