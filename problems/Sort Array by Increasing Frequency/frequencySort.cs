public class Solution {
    public int[] FrequencySort(int[] nums) {
        var store = new Dictionary<int, int>();

        foreach (int num in nums) {
            if (store.ContainsKey(num)) {
                ++store[num];
            } else {
                store.Add(num, 1);
            }
        }

        Array.Sort(nums, (a, b) => (store[a] == store[b]) ? b - a : store[a] - store[b]);

        return nums;
    }
}
