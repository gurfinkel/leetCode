public class Solution {
    public IList<string> LetterCombinations(string digits) {
        var map = new Dictionary<char, string>() { {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};
        var result = new List<string>();

        if (0 < digits.Length) {
            backtrack(result, map, digits, new StringBuilder());
        }

        return result;
    }

    private void backtrack(IList<string> res, Dictionary<char, string> map, string digits, StringBuilder sb, int idx = 0) {
        if (digits.Length == sb.Length) {
            res.Add(sb.ToString());
        } else {
            var digit = digits[idx];
            var letters = map[digit];

            foreach (var letter in letters) {
                sb.Append(letter);
                backtrack(res, map, digits, sb, 1 + idx);
                sb.Remove(sb.Length - 1, 1);
            }
        }
    }
}
