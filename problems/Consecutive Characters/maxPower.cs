public class Solution {
    public int MaxPower(string s) {
        int result = 1;
        int count = 1;

        for (int idx = 1; s.Length > idx; ++idx) {
            if (s[idx - 1] == s[idx]) {
                result = Math.Max(result, ++count);
            } else {
                result = Math.Max(result, count);
                count = 1;
            }
        }

        return result;
    }
}
