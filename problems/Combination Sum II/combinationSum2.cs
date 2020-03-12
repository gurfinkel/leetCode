public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        var result = new List<IList<int>>();
        if (candidates.Length == 0) return result;
        Array.Sort(candidates);
        DFS(candidates, target, 0, new List<int>(), result);
        return result;
    }

    private void DFS(int[] candidates, int target, int start, IList<int> oneResult, IList<IList<int>> result) {
        if (target == 0) {
            result.Add(new List<int>(oneResult));
        } else if (target > 0) {
            for (int i = start; i < candidates.Length; i++) {
                // NOTE: NOT if (i > 0)
                if (i > start && candidates[i - 1] == candidates[i]) continue;
                oneResult.Add(candidates[i]);
                DFS(candidates, target - candidates[i], i + 1, oneResult, result);
                oneResult.RemoveAt(oneResult.Count - 1);
            }
        }
    }
}
