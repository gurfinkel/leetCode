public class Solution {
    public string StringShift(string s, int[][] shift) {
        var sb = new StringBuilder(s);

        foreach (var item in shift) {
            if (0 == item[0]) {
                var subString = new char[item[1]];
                sb.CopyTo(0, subString, 0, item[1]);
                sb.Remove(0, item[1]);
                sb.Append(subString);
            } else {
                var subString = new char[item[1]];
                sb.CopyTo(sb.Length - item[1], subString, 0, item[1]);
                sb.Remove(sb.Length - item[1], item[1]);
                sb.Insert(0, subString);
            }
        }

        return sb.ToString();
    }
}
