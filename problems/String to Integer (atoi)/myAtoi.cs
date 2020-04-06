public class Solution {
    public int MyAtoi(string str) {
        str = str.Trim();

        if (0 == str.Length) {
            return 0;
        }

        var negative = '-' == str[0];
        var positive = '+' == str[0];
        var i = negative || positive ? 1 : 0;
        long result = 0;

        while (str.Length > i && char.IsDigit(str[i])) {
            result = 10 * result + (str[i++] - '0');
            if (result > int.MaxValue) {
                return negative ? int.MinValue : int.MaxValue;
            }
        }

        return negative ? -(int)result : (int)result;
    }
}
