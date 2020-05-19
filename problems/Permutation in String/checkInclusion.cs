public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        if (s1.Length > s2.Length) {
            return false;
        }

        var letterFrequencies1 = new int[26];
        var letterFrequencies2 = new int[26];

        foreach (var letter in s1) {
            ++letterFrequencies1[letter - 'a'];
        }

        for (var i = 0; s2.Length > i; ++i) {
            ++letterFrequencies2[s2[i] - 'a'];

            if (s1.Length <= i) {
                --letterFrequencies2[s2[i - s1.Length] - 'a'];
            }

            if (letterFrequencies1.SequenceEqual(letterFrequencies2)) {
                return true;
            }
        }

        return false;
    }
}
