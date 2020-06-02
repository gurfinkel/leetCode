public class Solution {
    public string FrequencySort(string s) {
        var store = new Dictionary<char, int>();
        var sb = new StringBuilder();

        foreach (var letter in s) {
            if (store.ContainsKey(letter)) {
                ++store[letter];
            } else {
                store.Add(letter, 1);
            }
        }

        var sortedLetters = store.ToList();

        sortedLetters.Sort((a, b) => b.Value - a.Value);

        foreach (var item in sortedLetters) {
            sb.Append(item.Key, item.Value);
        }

        return sb.ToString();
    }
}
