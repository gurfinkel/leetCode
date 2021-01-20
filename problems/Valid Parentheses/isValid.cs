public class Solution {
    public bool IsValid(string s) {
        Stack<char> store = new Stack<char>();

        foreach (char letter in s) {
            if (0 == store.Count || 40 == letter || 91 == letter || 123 == letter) {
                store.Push(letter);
            } else {
                char prevLetter = store.Pop();

                if (1 != (letter - prevLetter) && 2 != (letter - prevLetter)) {
                    return false;
                }
            }
        }

        return 0 == store.Count;
    }
}
