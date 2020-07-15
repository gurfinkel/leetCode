public class Solution {
    public string ReverseWords(string s) {
        var store = s.Split(" ");
        var stack = new Stack<string>();

        foreach (var item in store) {
            if (!String.IsNullOrEmpty(item)) {
                stack.Push(item);
            }
        }

        return String.Join(" ", stack);
    }
}
