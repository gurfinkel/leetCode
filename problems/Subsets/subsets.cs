public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        List<IList<int>> res = new List<IList<int>>()
        {
            new List<int>() //init with empty set
        };

        var helper = new NChooseK();
        for (int count = 1; count <= nums.Length; count++)
        {
            res.AddRange(helper.Combine(nums, count));
        }

        return res;
    }

    private class NChooseK
    {
        private void Helper(int[] nums, int[] buffer, int start, int index, IList<IList<int>> res)
        {
            if (index == buffer.Length)
            {
                res.Add(buffer.ToList());
                return;
            }

            for (int i = start; i < nums.Length; i++)
            {
                buffer[index] = nums[i];
                Helper(nums, buffer, i + 1, index + 1, res);
            }
        }

        public IList<IList<int>> Combine(int[] nums, int k)
        {
            IList<IList<int>> res = new List<IList<int>>();
            int[] buffer = new int[k];
            Helper(nums, buffer, 0, 0, res);
            return res;
        }
    }
}
