class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> dedupSet = new HashSet<>();

        Arrays.sort(nums);

        for (int idx = 0; nums.length > idx; ++idx) {
            if (0 == idx || nums[idx - 1] != nums[idx]) {
                List<int[]> twoSumList = twoSum(nums, -nums[idx], 1 + idx);

                for (int[] twoSumItem : twoSumList) {
                    String key = "" + nums[idx] + nums[twoSumItem[0]] + nums[twoSumItem[1]];

                    if (!dedupSet.contains(key)) {
                        List<Integer> threeSumItem = new ArrayList<>();
                        threeSumItem.add(nums[idx]);
                        threeSumItem.add(nums[twoSumItem[0]]);
                        threeSumItem.add(nums[twoSumItem[1]]);
                        result.add(threeSumItem);
                        dedupSet.add(key);
                    }
                }
            }
        }

        return result;
    }

    public List<int[]> twoSum(int[] nums, int k, int start) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int idx = start; nums.length > idx; ++idx) {
            if (store.containsKey(k - nums[idx])) {
                result.add(new int[] {store.get(k - nums[idx]), idx});
            }

            store.put(nums[idx], idx);
        }

        return result;
    }
}
