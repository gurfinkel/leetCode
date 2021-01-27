public class Solution {
    public bool IsOneEditDistance(string s, string t) {
        int i = 0;
        if (s.Length == t.Length) {
            int edit = 0;

            for (i = 0; s.Length > i; ++i) {
                if (s[i] != t[i]) {
                    ++edit;
                }
            }

            return 1 == edit;
        }

        string minS = s;
        string maxS = t;

        if (minS.Length > maxS.Length) {
            var tmp = minS;
            minS = maxS;
            maxS = tmp;
        }

        i = 0;
        int j = 0;
        int remove = 0;

        while (j < maxS.Length) {
            if (i < minS.Length && minS[i] == maxS[j]) {
                ++i;
                ++j;
                continue;
            }

            ++j;
            ++remove;
        }

        return 1 == remove && j == maxS.Length;
    }
}
