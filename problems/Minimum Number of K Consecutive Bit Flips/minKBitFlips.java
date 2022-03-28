class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int ans = 0;
        int flag = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == flag % 2) {
                if (i + k > nums.length) {
                    return -1;
                }
                ans++;
                flag++;
                nums[i] = -1;
            }
            if (i >= k - 1 && nums[i - k + 1] == -1) {
                flag--;
            }
        }
        return ans;
    }
}
