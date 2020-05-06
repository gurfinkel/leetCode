public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        var store = new Dictionary<char, int>();

        foreach (var item in magazine) {
            if (store.ContainsKey(item)) {
                ++store[item];
            } else {
                store.Add(item, 1);
            }
        }

        foreach (var item in ransomNote) {
            if (!store.ContainsKey(item) || 0 == store[item]) {
                return false;
            } else {
                --store[item];
            }
        }

        return true;
    }
}
