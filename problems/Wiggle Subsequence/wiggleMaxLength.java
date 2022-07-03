class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int down = 1;
        int up = 1;

        if (2 > n) {
            return n;
        }

        for (int idx = 1; n > idx; ++idx) {
            if (nums[idx - 1] < nums[idx]) {
                up = down + 1;
            } else if (nums[idx - 1] > nums[idx]) {
                down = up + 1;
            }
        }

        return Math.max(down, up);
    }
}
