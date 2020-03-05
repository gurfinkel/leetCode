public class Solution {
    public bool IsPalindrome(string s) {
        var store = new List<char>();

        foreach (var item in s) {
            if (char.IsDigit(item) || char.IsLetter(item)) {
                store.Add(char.ToLower(item));
            }
        }

        if (1 == (store.Count & 1)) {
            store.RemoveAt(store.Count >> 1);
        }

        var left = store.Take(store.Count >> 1).Reverse();
        var right = store.Skip(store.Count >> 1);

        return string.Join("", left) == string.Join("", right);
    }
}
