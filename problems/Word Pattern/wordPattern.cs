public class Solution {
    public bool WordPattern(string pattern, string str) {
        Dictionary<char, string> letterToWordMap = new Dictionary<char, string>();
        Dictionary<string, char> wordToLetterMap = new Dictionary<string, char>();
        String[] words = str.Split(' ');

        if (pattern.Length != words.Length) {
            return false;
        }

        for (int idx = 0; pattern.Length > idx; ++idx) {
            char letter = pattern[idx];
            string word = words[idx];

            if (letterToWordMap.ContainsKey(letter)) {
                if (letterToWordMap[letter] != word) {
                    return false;
                }
            } else {
                letterToWordMap.Add(letter, word);
            }

            if (wordToLetterMap.ContainsKey(word)) {
                if (wordToLetterMap[word] != letter) {
                    return false;
                }
            } else {
                wordToLetterMap.Add(word, letter);
            }
        }

        return true;
    }
}
