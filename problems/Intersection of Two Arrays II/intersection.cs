public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        var i = 0;
        var j = 0;
        var k = 0;

        Array.Sort(nums1);
        Array.Sort(nums2);

        while (nums1.Length > i && nums2.Length > j) {
            if (nums1[i] > nums2[j]) {
                ++j;
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }

        return nums1.Take(k).ToArray();
    }
}
