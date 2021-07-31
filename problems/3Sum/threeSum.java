class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        HashSet<String> store = new HashSet<String>();
        HashSet<Integer> numsUnique = new HashSet<Integer>();

        for (int idx = 0; nums.length - 2 > idx; ++idx) {
            if (numsUnique.add(nums[idx])) {
                List<int[]> twoSumList = twoSum(nums, 1 + idx, -nums[idx]);

                for (int[] item : twoSumList) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[idx]);
                    triplet.add(nums[item[0]]);
                    triplet.add(nums[item[1]]);

                    Collections.sort(triplet);

                    result.add(triplet);
                }
            }
        }

        return new ArrayList<List<Integer>>(result);
    }

    private List<int[]> twoSum(int[] nums, int start, int target) {
        List<int[]> result = new ArrayList<int[]>();
        HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();

        for (int idx = start; nums.length > idx; ++idx) {
            if (store.containsKey(target - nums[idx])) {
                result.add(new int[] {store.get(target - nums[idx]), idx});
            }

            store.put(nums[idx], idx);
        }

        return result;
    }
}
