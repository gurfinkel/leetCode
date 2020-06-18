public class Solution {
    public int SearchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.Length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
