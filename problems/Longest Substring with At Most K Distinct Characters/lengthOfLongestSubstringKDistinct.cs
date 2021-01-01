public class Solution {
    // Sliding Window + Hashmap
    public int LengthOfLongestSubstringKDistinct(string s, int k) {
        Dictionary<char, int> store = new Dictionary<char, int>();
        int result = 0;
        int left = 0;
        int right = 0;

        while (s.Length > left) {
            if (store.Count <= k) {
                result = Math.Max(result, right - left);

                if (s.Length == right) {
                    break;
                }

                if (!store.ContainsKey(s[right])) {
                    store[s[right]] = 0;
                }

                store[s[right++]]++;
                continue;
            }

            --store[s[left]];

            if (0 == store[s[left]]) {
                store.Remove(s[left]);
            }

            ++left;
        }

        return result;
    }
}
