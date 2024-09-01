class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumToIdxMap = new HashMap<>();
        int sum = 0;

        sumToIdxMap.put(0, 0);

        for (int idx = 0; nums.length > idx; ++idx) {
            sum += nums[idx];
            sum %= k;

            if (!sumToIdxMap.containsKey(sum)) {
                sumToIdxMap.put(sum, 1 + idx);
            } else if (0 < idx - sumToIdxMap.get(sum)){
                return true;
            }
        }

        return false;
    }
}
