public class Solution {
    public bool IsAnagram(string s, string t) {
        if (s.Length != t.Length) {
            return false;
        }

        var store = new int[26];

        for (var i = 0; s.Length > i; ++i) {
            ++store[s[i] - 'a'];
            --store[t[i] - 'a'];
        }

        foreach (var item in store) {
            if (0 != item) {
                return false;
            }
        }

        return true;
    }
}
