class Solution {
    public int subarraySum(int[] nums, int k) {
        return subarraySumOn1(nums, k);
        // return subarraySumOn2(nums, k);
    }

    private int subarraySumOn1(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSumToCount = new HashMap<>();

        prefixSumToCount.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (prefixSumToCount.containsKey(sum - k)) {
                result += prefixSumToCount.get(sum - k);
            }

            prefixSumToCount.put(sum, 1 + prefixSumToCount.getOrDefault(sum, 0));
        }

        return result;
    }

    private int subarraySumOn2(int[] nums, int k) {
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
