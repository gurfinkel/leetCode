class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int circular = 0;
        int minCircular = Integer.MAX_VALUE;
        int center = 0;
        int minCenter = Integer.MAX_VALUE;
        int ones = 0;

        for (int item : nums) {
            ones += item;
        }

        for (int idx = 0; ones > idx; ++idx) {
            center += 1 == nums[idx] ? 0 : 1;
            circular += 1 == nums[idx] ? 0 : 1;
        }

        minCenter = Math.min(minCenter, center);
        minCircular = Math.min(minCircular, circular);

        for (int idx = ones; n > idx; ++idx) {
            if (0 == nums[idx - ones] && 1 == nums[idx]) {
                --center;
                minCenter = Math.min(minCenter, center);
            } else if (1 == nums[idx - ones] && 0 == nums[idx]) {
                ++center;
            }
        }

        for (int idx = ones - 1; 0 <= idx; --idx) {
            if (0 == nums[n + idx - ones] && 1 == nums[idx]) {
                ++circular;
            } else if (1 == nums[n + idx - ones] && 0 == nums[idx]) {
                --circular;
                minCircular = Math.min(minCircular, circular);
            }
        }

        return Math.min(minCenter, minCircular);
    }
}
