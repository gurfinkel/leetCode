public class Solution {
    public IList<IList<int>> Generate(int numRows) {
        if (0 == numRows) {
            return new List<IList<int>>();
        }

        var result = new List<IList<int>> { new List<int> { 1 } };
        var row = 1;

        while (numRows > row) {
            result.Add(new List<int> { 1 });

            for (var i = 1; row > i; ++i) {
                result[row].Add(result[row - 1][i - 1] + result[row - 1][i]);
            }

            result[row++].Add(1);
        }

        return result;
    }
}
