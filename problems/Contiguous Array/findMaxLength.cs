public class Solution {
    public int FindMaxLength(int[] nums) {
        var max = 0;
        var count = 0;
        var map = new Dictionary<int, int>();

        map.Add(0, -1);

        for (var i = 0; nums.Length > i; ++i) {
            count += (nums[i] == 1 ? 1 : -1);

            if (map.ContainsKey(count)) {
                max = Math.Max(max, i - map[count]);
            } else {
                map.Add(count, i);
            }
        }

        return max;
    }
}
