public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        var result = new List<int>();
        var sLen = s.Length;
        var pLen = p.Length;

        if (sLen < pLen) {
            return result;
        }

        var pLetterFrequencies = new int[26];
        var sLetterFrequencies = new int[26];

        foreach (var letter in p) {
            ++pLetterFrequencies[letter - 'a'];
        }

        for (var i = 0; sLen > i; ++i) {
            ++sLetterFrequencies[s[i] - 'a'];

            if (pLen <= i) {
                --sLetterFrequencies[s[i - pLen] - 'a'];
            }

            if (pLetterFrequencies.SequenceEqual(sLetterFrequencies)) {
                result.Add(1 + i - pLen);
            }
        }

        return result;
    }
}
