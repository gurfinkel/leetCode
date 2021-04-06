class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> store = new HashMap<>() {{put(0, 0);}};
        int sum = 0;

        for (int idx = 0; nums.length > idx; ++idx) {
            sum += nums[idx];

            if (0 != k) {
                sum %= k;
            }

            if (!store.containsKey(sum)) {
                store.put(sum, 1 + idx);
            } else if (store.get(sum) < idx) {
                return true;
            }
        }

        return false;
    }
}
