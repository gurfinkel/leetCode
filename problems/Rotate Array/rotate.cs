public class Solution {
    public void Rotate(int[] nums, int k) {
        int n = nums.Length;

        k %= n;

        while (0 < k) {
            int prev = nums[n - 1];
            int next = -1;

            for (int idx = 0; n > idx; ++idx) {
                next = nums[idx];
                nums[idx] = prev;
                prev = next;
            }
            --k;
        }
    }
}
