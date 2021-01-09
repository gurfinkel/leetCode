public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var store = new HashSet<char>();
        var left = 0;
        var right = 0;
        var result = 0;

        while (s.Length > right) {
            if (store.Contains(s[right])) {
                store.Remove(s[left++]);
            } else {
                store.Add(s[right++]);
                result = Math.Max(result, store.Count);
            }
        }

        return result;
    }
}
