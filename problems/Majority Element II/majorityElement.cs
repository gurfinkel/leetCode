public class Solution {
    public IList<int> MajorityElement(int[] nums) {
        var candidate1 = 0;
        var count1 = 0;
        var candidate2 = 0;
        var count2 = 0;

        foreach (var item in nums) {
            if (candidate1 == item) {
                ++count1;
            } else if (candidate2 == item) {
                ++count2;
            } else if (0 == count1) {
                candidate1 = item;
                ++count1;
            } else if (0 == count2) {
                candidate2 = item;
                ++count2;
            } else {
                --count1;
                --count2;
            }
        }

        // check
        count1 = 0;
        count2 = 0;

        foreach (var item in nums) {
            if (candidate1 == item) {
                ++count1;
            } else if (candidate2 == item) {
                ++count2;
            }
        }

        var result = new List<int>();

        if (nums.Length / 3 < count1) {
            result.Add(candidate1);
        }
        if (nums.Length / 3 < count2) {
            result.Add(candidate2);
        }

        return result.ToArray();
    }
}
