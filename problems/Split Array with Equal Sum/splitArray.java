class Solution {
    public boolean splitArray(int[] nums) {
        if (7 > nums.length) {
            return false;
        }

        int[] sum = new int[nums.length];

        sum[0] = nums[0];

        for (int idx = 1; nums.length > idx; ++idx) {
            sum[idx] = sum[idx - 1] + nums[idx];
        }

        for (int idx = 3; nums.length - 3 > idx; ++idx) {
            HashSet<Integer> set = new HashSet<>();

            for (int i = 1; idx - 1 > i; i++) {
                if (sum[i - 1] == sum[idx - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }

            for (int j = 2 + idx; nums.length - 1 > j; ++j) {
                if (sum[nums.length - 1] - sum[j] == sum[j - 1] - sum[idx] && set.contains(sum[j - 1] - sum[idx])) {
                    return true;
                }
            }
        }

        return false;
    }
}
