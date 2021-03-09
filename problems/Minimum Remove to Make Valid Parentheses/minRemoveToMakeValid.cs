public class Solution {
    public string MinRemoveToMakeValid(string s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int openSeen = 0;
        int balance = 0;

        for (int idx = 0; s.Length > idx; ++idx) {
            if ('(' == s[idx]) {
                ++openSeen;
                ++balance;
            } else if (')' == s[idx]) {
                if (0 == balance) {
                    continue;
                }
                --balance;
            }

            sb.Append(s[idx]);
        }

        int openToKeep = openSeen - balance;

        for (int idx = 0; sb.Length > idx; ++idx) {
            if ('(' == sb[idx]) {
                --openToKeep;

                if (0 > openToKeep) {
                    continue;
                }
            }

            result.Append(sb[idx]);
        }

        return result.ToString();
    }
}
