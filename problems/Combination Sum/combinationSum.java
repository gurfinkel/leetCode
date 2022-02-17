class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), target, result);

        return result;
    }

    void backtrack(int[] candidates, int start, List<Integer> path, int target, List<List<Integer>> result) {
        if (0 == target) {
            result.add(path);
            return;
        }

        for (int idx = start; candidates.length > idx; ++idx) {
            if (target < candidates[idx]) {
                break;
            }
            path.add(candidates[idx]);
            backtrack(candidates, idx, new ArrayList<>(path), target - candidates[idx], result);
            path.remove(path.size() - 1);
        }
    }
}
