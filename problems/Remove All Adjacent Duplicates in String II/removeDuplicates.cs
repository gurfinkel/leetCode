public class Solution {
    public string RemoveDuplicates(string s, int k) {
        var stack = new Stack<(char, int)>();

        foreach (char letter in s) {
            if (0 < stack.Count && letter == stack.Peek().Item1) {
                if (k == 1 + stack.Peek().Item2) {
                    while (0 < stack.Count && letter == stack.Peek().Item1) {
                        stack.Pop();
                    }
                } else {
                    stack.Push((letter, 1 + stack.Peek().Item2));
                }

            } else {
                stack.Push((letter, 1));
            }
        }

        var sb = new StringBuilder();

        foreach (var letter in stack) {
            sb.Insert(0, letter.Item1);
        }

        return sb.ToString();
    }
}
