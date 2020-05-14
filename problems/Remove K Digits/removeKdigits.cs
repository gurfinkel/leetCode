public class Solution {
    public string RemoveKdigits(string num, int k) {
        var stack = new Stack<int>();
        var sb = new StringBuilder();
        var result = new StringBuilder();

        for (var i = 0; num.Length > i; ++i) {
            var digit = num[i] - '0';

            while (0 < stack.Count && stack.Peek() > digit && 0 < k) {
                stack.Pop();
                --k;
            }

            stack.Push(digit);
        }

        while (0 < k) {
            stack.Pop();
            --k;
        }

        foreach (var digit in stack) {
            if (0 == digit) {
                sb.Insert(0, digit);
            } else {
                sb.Insert(0, digit);
                result.Insert(0, sb);
                sb.Clear();
            }
        }

        return 0 == result.Length ? "0" : result.ToString();
    }
}
