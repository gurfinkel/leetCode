public class Solution {
    public bool CanPartition(int[] nums) {
        var sum = nums.Sum();
        if (sum % 2 != 0) return false;

        var half = sum / 2;
        if (half < nums.Max()) return false;

        Array.Sort(nums);
        return Helper(nums, nums.Length - 1, half);
    }

    private bool Helper(int[] nums, int endIndex, int remaining) {
        if (remaining == 0 || nums[endIndex] == remaining) return true;

        if (nums[endIndex] > remaining) return false;

        for(var i = endIndex - 1; i >= 0; i--) {
            //Console.WriteLine($"{endIndex} - {i}");
            if(Helper(nums, i, remaining - nums[endIndex])) {
                return true;
            }
        }

        return false;
    }
}
