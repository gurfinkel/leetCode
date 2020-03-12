public class Solution {
    // Sliding Window + Hashmap
    public int LengthOfLongestSubstringKDistinct(string s, int k) {
        int res = 0;
        int l = 0;
        int r = l;
        Dictionary<char, int> char2Count = new Dictionary<char, int>();

        while (l < s.Length)
        {
            if (char2Count.Count <= k)
            {
                res = Math.Max(res, r - l);

                if (r == s.Length)
                {
                    break;
                }

                if (!char2Count.ContainsKey(s[r]))
                {
                    char2Count[s[r]] = 0;
                }

                char2Count[s[r]]++;
                r++;
                continue;
            }

            char2Count[s[l]]--;
            if (char2Count[s[l]] == 0)
            {
                char2Count.Remove(s[l]);
            }

            l++;
        }

        return res;
    }
}
