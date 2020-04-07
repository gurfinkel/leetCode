public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        var idx = nums1.Length - 1;
        var idx1 = m - 1;
        var idx2 = n - 1;

        while (0 <= idx1 || 0 <= idx2) {
            if (0 <= idx1 && 0 <= idx2) {
                if (nums1[idx1] > nums2[idx2]) {
                    nums1[idx--] = nums1[idx1--];
                } else {
                    nums1[idx--] = nums2[idx2--];
                }
            } else if (0 <= idx1) {
                nums1[idx--] = nums1[idx1--];
            } else {
                nums1[idx--] = nums2[idx2--];
            }
        }
    }
}
