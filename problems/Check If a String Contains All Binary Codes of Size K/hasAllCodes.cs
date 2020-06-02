public class Solution {
    public bool HasAllCodes(string s, int k) {
        var store = new HashSet<string>();

		if (0 > s.Length - k) {
            return false;
        }

		for (var i = 0; s.Length - k >= i; ++i) {
            var str = s.Substring(i, k);

            if (!store.Contains(str)) {
                store.Add(str);
            }
        }

		return store.Count == Math.Pow(2, k);
    }
}
