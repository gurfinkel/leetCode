public class Solution {
    public string ToGoatLatin(string S) {
        var vowels = new HashSet<char> {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        var arr = S.Split(" ");
        var index = 1;
        var result = new List<string>();

        for (int idx = 0; arr.Length > idx; ++idx) {
            var word = arr[idx];

            if (String.IsNullOrEmpty(word)) {
                continue;
            }

            var newWord = new StringBuilder();

            if (vowels.Contains(word[0])) {
                newWord.Append(word);
            } else {
                newWord.Append(word.Substring(1, word.Length - 1));
                newWord.Append(word[0]);
            }

            newWord.Append("ma");
            newWord.Append(new String('a', index++));
            result.Add(newWord.ToString());
        }

        return String.Join(" ", result);
    }
}
