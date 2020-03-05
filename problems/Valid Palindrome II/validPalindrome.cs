public class Solution {
    public bool ValidPalindrome(string s) {
        int left = 0;
        int right = s.Length - 1;

        while (left < right) {
            if (s[left] == s[right]) {
                ++left;
                --right;
            } else {
                return IsValidPalindrome(s, 1 + left, right) ||
                    IsValidPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    public bool IsValidPalindrome(string s, int left, int right) {
        while (left < right) {
            if (s[left] == s[right]) {
                ++left;
                --right;
            } else {
                return false;
            }
        }

        return true;
    }
}
