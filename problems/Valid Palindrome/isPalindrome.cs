public class Solution {
    public bool IsPalindrome(string s) {
        var n = s.Length;
        var l = 0;
        var r = n - 1;

        while (l < r) {
            while (l < r && !char.IsLetter(s[l]) && !char.IsDigit(s[l])) {++l;}
            while (l < r && !char.IsLetter(s[r]) && !char.IsDigit(s[r])) {--r;}

            if (l > r || char.ToLower(s[l++]) != char.ToLower(s[r--])) {
                return false;
            }
        }

        return true;
    }
}
