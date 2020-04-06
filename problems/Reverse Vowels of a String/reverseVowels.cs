public class Solution {
    public string ReverseVowels(string s) {
        var store = new HashSet<char>(new []{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
        var stack = new Stack<char>();
        var queue = new Queue<char>();
        var sb = new StringBuilder();

        foreach (var item in s) {
            if (store.Contains(item)) {
                queue.Enqueue('$');
                stack.Push(item);
            } else {
                queue.Enqueue(item);
            }
        }

        foreach (var item in queue) {
            if ('$' == item) {
                sb.Append(stack.Pop());
            } else {
                sb.Append(item);
            }
        }

        return sb.ToString();
    }
}
