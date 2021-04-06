class Solution {
    HashMap<Integer, List<Integer>> _store;
    Random _random;

    public Solution(int[] nums) {
        _random = new Random();
        _store = new HashMap<>();

        for (int idx = 0; nums.length > idx; ++idx) {
            if (!_store.containsKey(nums[idx])) {
                _store.put(nums[idx], new ArrayList<>());
            }

            _store.get(nums[idx]).add(idx);
        }
    }

    public int pick(int target) {
        List<Integer> items = _store.get(target);

        return items.get(_random.nextInt(items.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
