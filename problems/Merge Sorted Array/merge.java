class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n;
        int idx1 = m - 1;
        int idx2 = n - 1;

        while (0 <= idx2) {
            if (0 <= idx1 && nums1[idx1] > nums2[idx2]) {
                nums1[--idx] = nums1[idx1--];
            } else {
                nums1[--idx] = nums2[idx2--];
            }
        }
    }
}
