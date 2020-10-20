public class Solution {
    public IList<string> FindRepeatedDnaSequences(string s) {
        var store = new HashSet<string>();
        var result = new HashSet<string>();

        for (int idx = 9; s.Length > idx; ++idx) {
            string dna = s.Substring(idx - 9, 10);

            if (store.Contains(dna)) {
                result.Add(dna);
            }

            store.Add(dna);
        }

        return result.ToList();
    }
}
