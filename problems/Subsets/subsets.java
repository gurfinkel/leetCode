class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int idx = 0; nums.length >= idx; ++idx) {
            backtrack(new ArrayList<>(), nums, result, idx, 0);
        }

        return result;
    }

    private void backtrack(List<Integer> currSubset, int[] nums, List<List<Integer>> result, int count, int idx) {
        if (count == idx) {
            result.add(currSubset);
        }

        for (int i = idx; nums.length > i; ++i) {
            currSubset.add(nums[i]);
            backtrack(new ArrayList<>(currSubset), nums, result, count, 1 + i);
            currSubset.remove(currSubset.size() - 1);
        }
    }
}
