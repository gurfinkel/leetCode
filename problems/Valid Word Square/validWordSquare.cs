public class Solution {
    public bool ValidWordSquare(IList<string> words) {
        var rows = words.Count;

        for (var i = 0; rows > i; ++i) {
            for (var j = 0; words[i].Length > j; ++j) {
                if (j >= rows || i >= words[j].Length || words[i][j] != words[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
