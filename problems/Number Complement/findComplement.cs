public class Solution {
    public int FindComplement(int num) {
        var result = 0;
        var stack = new Stack<int>();

        while (0 < num) {
            stack.Push((num % 2) ^ 1);
            num >>= 1;
        }

        while (0 < stack.Count) {
            result = 2 * result + stack.Pop();
        }

        return result;
    }
}
