public class Solution {
    public string ConvertToTitle(int columnNumber) {
        var stack = new Stack<char>();

        while (0 < columnNumber) {
            stack.Push((char)('A' + --columnNumber % 26));
            columnNumber /= 26;
        }

        return string.Join("", stack);
    }
}
