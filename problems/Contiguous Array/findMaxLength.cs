public class Solution {
    public int FindMaxLength(int[] nums) {
        var result = 0;
        var count = 0;
        var map = new Dictionary<int, int> {{0, -1}};

        for (var i = 0; nums.Length > i; ++i) {
            count += (nums[i] == 1 ? 1 : -1);

            if (map.ContainsKey(count)) {
                result = Math.Max(result, i - map[count]);
            } else {
                map.Add(count, i);
            }
        }

        return result;
    }
}
