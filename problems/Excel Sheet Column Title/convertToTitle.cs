public class Solution {
    public string ConvertToTitle(int n) {
        var stack = new Stack<char>();

        while (0 < n) {
            stack.Push((char)('A' + --n % 26));
            n /= 26;
        }

        return string.Join("", stack);
    }
}
