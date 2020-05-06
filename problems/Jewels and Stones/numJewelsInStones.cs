public class Solution {
    public int NumJewelsInStones(string J, string S) {
        var store = new HashSet<char>(J.ToCharArray());
        var result = 0;

        foreach (var item in S) {
            if (store.Contains(item)) {
                ++result;
            }
        }

        return result;
    }
}
