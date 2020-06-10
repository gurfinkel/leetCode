public class Solution {
    public int[] Shuffle(int[] nums, int n) {
        int[] result = new int[n << 1];
        int len = nums.Length;
        int idx = 0;
        int count = 0;
        int i = 0;

        while (result.Length > i) {
            result[i++] = nums[idx];
            idx += n;

            if (len <= idx) {
                idx = ++count;
            }
        }

        return result;
    }
}
