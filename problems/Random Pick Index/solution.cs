public class Solution {

    public Solution(int[] nums) {
        _random = new Random();
        _store = nums;
    }

    public int Pick(int target) {
        int result = 0;
        int count = 0;

        for (int idx = 0; _store.Length > idx; ++idx) {
            if (_store[idx] == target) {
                ++count;

                if (0 == _random.Next(count)) {
                    result = idx;
                }
            }
        }
        return result;
    }

    private readonly int[] _store;
    private readonly Random _random;
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.Pick(target);
 */
