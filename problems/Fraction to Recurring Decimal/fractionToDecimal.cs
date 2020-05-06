public class Solution {
    public string FractionToDecimal(int numerator, int denominator) {
        if (0 == numerator) {
            return "0";
        }

        var fraction = new StringBuilder();

        if (0 > numerator ^ 0 > denominator) {
            fraction.Append("-");
        }

        long dividend = Math.Abs((long)numerator);
        long divisor = Math.Abs((long)denominator);
        long remainder = dividend % divisor;

        fraction.Append((dividend / divisor).ToString());

        if (0 == remainder) {
            return fraction.ToString();
        }

        fraction.Append(".");

        var map = new Dictionary<long, int>();

        while (0 != remainder) {
            if (map.ContainsKey(remainder)) {
                fraction.Insert(map[remainder], "(");
                fraction.Append(")");
                break;
            }
            map.Add(remainder, fraction.Length);
            remainder *= 10;
            fraction.Append((remainder / divisor).ToString());
            remainder %= divisor;
        }

        return fraction.ToString();
    }
}