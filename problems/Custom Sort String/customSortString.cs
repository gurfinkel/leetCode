public class Solution {
    public string CustomSortString(string S, string T) {
        StringBuilder sb = new StringBuilder(T.Length);
        int[] tChars = new int[26];

        foreach (var tChar in T) {
            tChars[tChar - 'a']++;
        }

        foreach (var sc in S) {
            sb.Append(sc, tChars[sc - 'a']);
            tChars[sc - 'a'] = 0;
        }

        for (int i = 0; i < tChars.Length; i++) {
            sb.Append((char) (i + 'a'), tChars[i]);
        }

        return sb.ToString();
    }
}
