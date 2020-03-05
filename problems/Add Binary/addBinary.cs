public class Solution {
    public string AddBinary(string a, string b) {
        var result = new Stack<int>();
        var memory = 0;
        var aIndex = a.Length - 1;
        var bIndex = b.Length - 1;

        while (0 <= aIndex || 0 <= bIndex || 1 == memory) {
            var aDigit = 0 <= aIndex && '1' == a[aIndex--] ? 1 : 0;
            var bDigit = 0 <= bIndex && '1' == b[bIndex--] ? 1 : 0;
            result.Push(aDigit ^ bDigit ^ memory);
            memory = (1 == (aDigit & bDigit)) || (1 == ((aDigit ^ bDigit) & memory)) ? 1 : 0;
        }

        return string.Join("", result);
    }
}
