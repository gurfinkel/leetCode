public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        var result = new List<IList<string>>();
        var store = new Dictionary<string, int>();

        if (null == strs || 0 == strs.Length) {
            return result;
        }

        foreach (var item in strs) {
            var str = item.ToCharArray();

            Array.Sort(str);

            var key = string.Join("", str);

            if (store.ContainsKey(key)) {
                result[store[key]].Add(item);
            } else {
                result.Add(new List<string> {item});
                store.Add(key, result.Count - 1);
            }
        }

        return result;
    }
}
