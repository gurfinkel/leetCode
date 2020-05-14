public class Solution {
    public int FirstUniqChar(string s) {
        var store = new int[26];
        var stack = new Stack<int>();

        for (var i = s.Length - 1; 0 <= i; --i) {
            if (0 < store[s[i] - 'a']) {
                ++store[s[i] - 'a'];
                while (0 < stack.Count && 1 < store[s[stack.Peek()] - 'a']) {
                    stack.Pop();
                }
            } else {
                ++store[s[i] - 'a'];
                stack.Push(i);
            }
        }

        return 0 == stack.Count ? -1 : stack.Pop();
    }
}
