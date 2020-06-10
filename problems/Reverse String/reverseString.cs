public class Solution {
    public void ReverseString(char[] s) {
        var n = s.Length - 1;
        var half = s.Length >> 1;
        var idx = 0;

        while (half > idx) {
            var letter = s[idx];
            s[idx] = s[n - idx];
            s[n - idx] = letter;
            ++idx;
        }
    }
}
