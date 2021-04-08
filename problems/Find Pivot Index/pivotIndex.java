class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[1 + n];

        for (int idx = 0; n > idx; ++idx) {
            prefixSums[1 + idx] = nums[idx] + prefixSums[idx];
        }

        for (int idx = 0; n > idx; ++idx) {
            if (prefixSums[idx] == prefixSums[n] - prefixSums[1 + idx]) {
                return idx;
            }
        }

        return -1;
    }
}
