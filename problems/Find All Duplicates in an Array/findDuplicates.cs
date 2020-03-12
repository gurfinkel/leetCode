public class Solution {
    public IList<int> FindDuplicates(int[] nums) {
        IList<int> res = new List<int>();

        for (int i = 0; i < nums.Length; i++)
        {
            int val = nums[i];

            int idx = val <= 0 ? val + nums.Length - 1 : val - 1;

            if (nums[idx] <= 0)
            {
                res.Add(idx + 1);
            }
            else
            {
                nums[idx] -= nums.Length;
            }
        }

        return res;
    }
}
