public class Solution {
    public string ShortestPalindrome(string s) {
        int end = -1;
        for (int i = 0; i < s.Length; i++)
        {
            int l = 0;
            int r = i;

            bool valid = true;
            while (l < r)
            {
                if (s[l] != s[r])
                {
                    valid = false;
                    break;
                }

                l++;
                r--;
            }

            if (valid)
            {
                end = i;
            }
        }

        StringBuilder sb = new StringBuilder(s.Length + s.Length - (end + 1));
        Stack<char> reversedPrefix = new Stack<char>(s.Length - (end + 1));
        for (int i = end + 1; i < s.Length; i++)
        {
            reversedPrefix.Push(s[i]);
        }

        while (reversedPrefix.Count > 0)
        {
            sb.Append(reversedPrefix.Pop());
        }

        sb.Append(s);

        return sb.ToString();
    }
}
