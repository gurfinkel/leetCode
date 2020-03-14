public class Solution {
    public bool CheckSubarraySum(int[] nums, int k) {
        var sum = 0;
        var store = new Dictionary<int, int>();

        store.Add(0, 0);

        for (var i = 0; nums.Length > i; ++i) {
            sum += nums[i];

            if (0 != k) {
                sum %= k;
            }

            if (!store.ContainsKey(sum)) {
                store.Add(sum, 1 + i);
            } else if (store[sum] < i) {
                return true;
            }
        }

        return false;
    }
}
