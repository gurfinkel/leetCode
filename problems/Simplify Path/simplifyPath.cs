public class Solution {
    public string SimplifyPath(string path) {
        var stack = new Stack<string>();
        var store = path.Trim('/').Split('/');

        foreach (var item in store) {
            if ("." == item || string.IsNullOrEmpty(item)) {
                continue;
            } else if (".." == item) {
                if (0 < stack.Count) {
                    stack.Pop();
                }
            } else {
                stack.Push(item);
            }
        }

        return '/' + string.Join("/", stack.Reverse());
    }
}
