public class Solution {
    public bool CheckValidString(string s) {
        var l = 0;
        var r = 0;

        foreach (var letter in s) {
            l += '(' == letter ? 1 : -1;
            r += ')' != letter ? 1 : -1;

            if (0 > r) {
                break;
            }

            l = Math.Max(0, l);
        }

        return 0 == l;
    }
}
