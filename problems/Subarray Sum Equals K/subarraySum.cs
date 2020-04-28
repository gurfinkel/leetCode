public class Solution {
    public int SubarraySum(int[] nums, int k) {
        var result = 0;
        var sum = 0;
        var store = new Dictionary<int, int> {{0, 1}};

        foreach (var item in nums) {
            sum += item;

            if (store.ContainsKey(sum - k)) {
                result += store[sum - k];
            }

            if (store.ContainsKey(sum)) {
                ++store[sum];
            } else {
                store.Add(sum, 1);
            }
        }

        return result;
    }
}
