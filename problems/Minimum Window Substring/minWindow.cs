public class Solution {
    public string MinWindow(string s, string t) {
        var letterStore = new int[128];
        var result = "";

        foreach (var letter in t) {
            ++letterStore[letter];
        }

        for (int right = 0, left = 0, count = 0; s.Length > right; ++right) {
            if (0 < letterStore[s[right]]--) {
                ++count;
            }

            while (t.Length == count) {
                if ("" == result || result.Length > 1 + right - left) {
                    result = s.Substring(left, 1 + right - left);
                }

                if (0 < ++letterStore[s[left++]]) {
                   --count;
                }
            }
        }

        return result;
    }
}
