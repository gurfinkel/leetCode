public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        var result = new List<IList<int>>();
        var n = nums.Length;

        for (var k = 0; n >= k; ++k) {
            backtrack(new List<int>(), nums, result, k);
        }

        return result;
    }

    private void backtrack(List<int> curr, int[] nums, IList<IList<int>> res, int count, int idx = 0) {
        // if the combination is done
        if (curr.Count == count) {
            res.Add(curr.ToList());
        }

        for (var i = idx; nums.Length > i; ++i) {
            // add i into the current combination
            curr.Add(nums[i]);
            // use next integers to complete the combination
            backtrack(curr, nums, res, count, 1 + i);
            // backtrack
            curr.RemoveAt(curr.Count - 1);
        }
    }
}
