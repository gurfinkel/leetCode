public class Solution {
    public string AddStrings(string num1, string num2) {
        var result = new Stack<int>();
        var memory = 0;
        var aIndex = num1.Length - 1;
        var bIndex = num2.Length - 1;

        while (0 <= aIndex || 0 <= bIndex || 1 == memory) {
            var nextDigit = memory;
            nextDigit += 0 <= aIndex ? num1[aIndex--] - '0' : 0;
            nextDigit += 0 <= bIndex ? num2[bIndex--] - '0' : 0;
            result.Push(nextDigit % 10);
            memory = nextDigit / 10;
        }

        return string.Join("", result);
    }
}
