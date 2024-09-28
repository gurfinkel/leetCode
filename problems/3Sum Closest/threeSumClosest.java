class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int n = nums.length;

        Arrays.sort(nums);

        for (int idx = 0; n > idx && 0 != diff; ++idx) {
            int left = idx + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[idx] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (target > sum) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return target - diff;
    }
}
