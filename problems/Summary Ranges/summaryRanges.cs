public class Solution {
    public IList<string> SummaryRanges(int[] nums) {
        List<string> result = new List<string>();

        if (null == nums || 0 == nums.Length) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int idx = 1; nums.Length > idx; ++idx) {
            if (1 + end < nums[idx]) {
                result.Add(start == end ? String.Format("{0}", start) : String.Format("{0}->{1}", start, end));
                start = nums[idx];
                end = nums[idx];
            } else {
                end = nums[idx];
            }
        }

        result.Add(start == end ? String.Format("{0}", start) : String.Format("{0}->{1}", start, end));

        return result;
    }
}
