public class Solution {
    public string LargestNumber(int[] nums) {
        Array.Sort(nums, (a, b) => (b + "" + a).CompareTo(a + "" + b));

        return 0 == nums[0] ? "0" : string.Join("", nums);
    }
}
