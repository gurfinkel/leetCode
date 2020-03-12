public class Solution {
    public int LengthOfLongestSubstringTwoDistinct(string s) {
        if (s.Length == 0)
        {
            return 0;
        }

        IDictionary<char, int> char2Count = new Dictionary<char, int>();
        int left = 0;
        int right = 0;
        char2Count[s[left]] = 1;
        int res = 0;

        while (left != s.Length)
        {
            if (char2Count.Count <= 2)
            {
                res = Math.Max(res, right - left + 1);
                right++;
                if (right < s.Length)
                {
                    if (!char2Count.ContainsKey(s[right]))
                    {
                        char2Count[s[right]] = 0;
                    }

                    char2Count[s[right]]++;
                }
                else
                {
                    right = s.Length;
                    char2Count[s[left]]--;
                    if (char2Count[s[left]] == 0)
                    {
                        char2Count.Remove(s[left]);
                    }
                    left++;
                }
                continue;
            }

            char2Count[s[left]]--;
            if (char2Count[s[left]] == 0)
            {
                char2Count.Remove(s[left]);
            }
            left++;
        }

        return res;
    }
}
