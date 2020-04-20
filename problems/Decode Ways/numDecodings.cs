public class Solution {
    public int NumDecodings(string s) {
        if (string.IsNullOrEmpty(s)) {
            return 0;
        }

        var currMinusTwo = 1;
        var currMinusOne = '0' == s[0] ? 0 : 1;
        var curr = currMinusOne;

        for (var i = 2; s.Length >= i; ++i) {
            var oneDigit = s[i - 1] - '0';
            var twoDigits = 10 * (s[i - 2] - '0') + (s[i - 1] - '0');

            curr = (0 == oneDigit ? 0 : currMinusOne);
            curr += (10 <= twoDigits && 26 >= twoDigits ? currMinusTwo : 0);
            currMinusTwo = currMinusOne;
            currMinusOne = curr;
        }

        return curr;
    }
}
