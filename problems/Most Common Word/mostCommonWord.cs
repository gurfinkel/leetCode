public class Solution {
    public string MostCommonWord(string paragraph, string[] banned) {
        var str = stripPunctuation(paragraph.Trim());
        var words = str.Split(' ');
        var store = new Dictionary<string, int>();
        var bannedWords = new HashSet<String>(banned);
        var counter = 0;
        var result = "";

        foreach (string item in words) {
            if (String.IsNullOrWhiteSpace(item)) {
                continue;
            }

            string word = item.ToLower();

            if (!bannedWords.Contains(word)) {
                if (store.ContainsKey(word)) {
                    ++store[word];
                } else {
                    store.Add(word, 1);
                }
            }
        }

        foreach (var word in store) {
            if (counter < word.Value) {
                counter = word.Value;
                result = word.Key;
            }
        }

        return result;
    }

    private string stripPunctuation(String str) {
        var sb = new StringBuilder();

        foreach (char letter in str) {
            if (char.IsPunctuation(letter)) {
                sb.Append(' ');
            } else {
                sb.Append(letter);
            }
        }

        return sb.ToString();
    }
}
