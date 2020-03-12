public class Solution {
    public IList<string> RestoreIpAddresses(string s) {
        var result = new List<string>();
        DFS(s, 0, 0, new List<string>(), result);
        return result;
    }

    private void DFS(string s, int startIndex, int count, IList<string> oneResult, IList<string> result) {
        if (!canContinue(s, startIndex, count)) return;

        if (count == 4 && s.Length == startIndex) {
            result.Add(string.Join(".", oneResult));
        }

        for (int tempCount = 1; tempCount <= 3; tempCount++) {
            if (isValid(s, startIndex, tempCount)) {
                oneResult.Add(s.Substring(startIndex, tempCount));
                DFS(s, startIndex + tempCount, count + 1, oneResult, result);
                oneResult.RemoveAt(oneResult.Count - 1);
            }
        }
    }

    private bool canContinue(string s, int startIndex, int count) {
        return s.Length - startIndex <= (4 - count) * 3;
    }

    private bool isValid(string s, int left, int len) {
        if (left + len > s.Length) return false;
        if (len > 3) return false;
        if (len == 1) {
            return true;
        } else if (len == 2) {
            if (s[left] != '0') {
                return true;
            }
        } else if (len == 3) {
            if (s[left] != '0') {
                var num = int.Parse(s.Substring(left, len));
                if (0 <= num && num <= 255) {
                    return true;
                }
            }
        }
        return false;
    }
}
