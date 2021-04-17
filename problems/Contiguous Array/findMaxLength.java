class Solution {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>() {{put(0, -1);}};

        for (int idx = 0; nums.length > idx; ++idx) {
            count += (1 == nums[idx] ? 1 : -1);

            if (map.containsKey(count)) {
                result = Math.max(result, idx - map.get(count));
            } else {
                map.put(count, idx);
            }
        }

        return result;
    }
}
