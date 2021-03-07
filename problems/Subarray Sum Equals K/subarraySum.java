class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        int[] prefixSums = new int[1 + n];

        for (int idx = 0; n > idx; ++idx) {
            prefixSums[1 + idx] = nums[idx] + prefixSums[idx];
        }

        for (int i = 1; n >= i; ++i) {
            for (int j = 0; i > j; ++j) {
                if (k == prefixSums[i] - prefixSums[j]) {
                    ++result;
                }
            }
        }

        return result;
    }
}
