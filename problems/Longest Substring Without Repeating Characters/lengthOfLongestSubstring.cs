public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var store = new HashSet<char>();
        var l = 0;
        var r = 0;
        var result = 0;

        while (s.Length > r) {
            if (store.Contains(s[r])) {
                store.Remove(s[l++]);
            } else {
                store.Add(s[r++]);
                result = Math.Max(result, store.Count);
            }
        }

        return result;
    }
}
