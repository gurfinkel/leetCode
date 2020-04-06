public class Solution {
    // Boyer-Moore Voting Algorithm
    public int MajorityElement(int[] nums) {
        var count = 0;
        var candidate = -1;

        foreach (var num in nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
