public class Solution {
    public IList<IList<int>> PermuteUnique(int[] nums) {
        IList<IList<int>> result = new List<IList<int>>();
        HashSet<string> store = new HashSet<string>();

        backtrack(nums, result, store);

        return result;
    }

    private void backtrack(int[] arr, IList<IList<int>> res, HashSet<string> store, int idx = 0) {
        if (idx == arr.Length) {
            string key = String.Join(",", arr);

            if (!store.Contains(key)) {
                store.Add(key);
                res.Add(arr.ToList());
            }
        }

        for (var i = idx; arr.Length > i; ++i) {
            swap(arr, idx, i);
            backtrack(arr, res, store, 1 + idx);
            swap(arr, i, idx);
        }
    }

    private void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
