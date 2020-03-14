public class Solution {
    public string Multiply(string num1, string num2) {
        var m = num1.Length;
        var n = num2.Length;
        var result = new int[m + n];

        for (var i = m - 1; 0 <= i; --i) {
            for (var j = n - 1; 0 <= j; --j) {
                var multiply = (num1[i] - '0') * (num2[j] - '0');
                var sum = multiply + result[1 + i + j];

                result[1 + i + j] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        var sb = new StringBuilder();

        foreach (var digit in result) {
            if (!(0 == digit && 0 == sb.Length)) {
                sb.Append(digit);
            }
        }

        return 0 == sb.Length ? "0" : sb.ToString();
    }
}
