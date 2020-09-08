public class Solution {
    public IList<int> FindDuplicates(int[] nums) {
        int n = nums.Length;
        IList<int> result = new List<int>();

        foreach (int num in nums) {
            int idx = 0 >= num ? num + n - 1 : num - 1;

            if (nums[idx] <= 0) {
                result.Add(1 + idx);
            } else {
                nums[idx] -= n;
            }
        }

        return result;
    }
}
