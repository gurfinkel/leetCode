public class Solution {
    public string MinRemoveToMakeValid(string s) {
        var indexesToRemove = new HashSet<int>();
        var stack = new Stack<int>();

        for (int i = 0; i < s.Length; i++) {
            if (s[i] == '(') {
                stack.Push(i);
            } if (s[i] == ')') {
                if (0 == stack.Count()) {
                    indexesToRemove.Add(i);
                } else {
                    stack.Pop();
                }
            }
        }

        // Put any indexes remaining on stack into the set.
        while (0 < stack.Count())
            indexesToRemove.Add(stack.Pop());

        var sb = new StringBuilder();

        for (int i = 0; i < s.Length; i++) {
            if (!indexesToRemove.Contains(i)) {
                sb.Append(s[i]);
            }
        }

        return sb.ToString();
    }
}
