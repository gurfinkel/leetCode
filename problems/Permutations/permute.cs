public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        var output = new List<IList<int>>();

        backtrack(nums, output);

        return output;
    }

    private void backtrack(int[] nums, List<IList<int>> output, int first = 0) {
            if (first == nums.Length) {
                output.Add(nums.ToList());
            }

            for (var i = first; nums.Length > i; ++i) {
                // place i-th integer first
                // in the current permutation
                swap(nums, first, i);
                // use next integers to complete the permutations
                backtrack(nums, output, 1 + first);
                // backtrack
                swap(nums, first, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
