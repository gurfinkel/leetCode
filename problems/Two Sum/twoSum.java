class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int idx = 0; nums.length > idx; ++idx) {
            if (store.containsKey(target - nums[idx])) {
                return new int[] {store.get(target - nums[idx]), idx};
            }

            store.put(nums[idx], idx);
        }

        return null;
    }
}
