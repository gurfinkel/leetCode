public class Solution {
    public IList<string> FindStrobogrammatic(int n) {
        var map = new [] {'0','0','1','1','6','9','8','8','9','6'};
        var result = new List<string>();
        var sb = new StringBuilder();

        sb.Append('0', n);
        checkNumber(result, sb, map, 0, n - 1);

        return result;
    }

    private void checkNumber(IList<string> res, StringBuilder sb, char[] map, int l, int r) {
        if (l > r) {
            res.Add(sb.ToString());
        } else if (l == r) {
            sb[l] = '0';
            checkNumber(res, sb, map, 1 + l, r - 1);
            sb[l] = '1';
            checkNumber(res, sb, map, 1 + l, r - 1);
            sb[l] = '8';
            checkNumber(res, sb, map, 1 + l, r - 1);
        } else {
            for (var i = 0 == l ? 2 : 0; map.Length - 1 > i; i += 2) {
                sb[l] = map[i];
                sb[r] = map[1 + i];
                checkNumber(res, sb, map, 1 + l, r - 1);
            }
        }
    }
}
