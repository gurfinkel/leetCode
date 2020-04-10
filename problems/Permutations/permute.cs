public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        var result = new List<IList<int>>();

        backtrack(nums, result);

        return result;
    }

    private void backtrack(int[] arr, IList<IList<int>> res, int idx = 0) {
        if (idx == arr.Length) {
            res.Add(arr.ToList());
        }

        for (var i = idx; arr.Length > i; ++i) {
            swap(arr, idx, i);
            backtrack(arr, res, 1 + idx);
            swap(arr, i, idx);
        }
    }

    private void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
