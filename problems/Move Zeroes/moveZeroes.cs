public class Solution {
    public void MoveZeroes(int[] nums) {
        for (int i = 0, j = 0; nums.Length > i; ++i) {
            if (0 != nums[i]) {
                nums[j++] = nums[i];
            }
            if (i >= j) {
                nums[i] = 0;
            }
        }
    }
}
