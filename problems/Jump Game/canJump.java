class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIdx = n - 1;

        for (int idx = n - 1; 0 <= idx; --idx) {
            if (idx + nums[idx] >= lastIdx) {
                lastIdx = idx;
            }
        }

        return 0 == lastIdx;
    }
}
