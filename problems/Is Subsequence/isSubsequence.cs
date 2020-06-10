public class Solution {
    public bool IsSubsequence(string s, string t) {
        int patternIdx = 0;
        int textIdx = 0;

        while (s.Length > patternIdx && t.Length > textIdx) {
            if (s[patternIdx] == t[textIdx]) {
                ++patternIdx;
            }
            ++textIdx;
        }

        return s.Length == patternIdx;
    }
}
