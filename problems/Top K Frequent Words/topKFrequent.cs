public class Solution {
    public IList<string> TopKFrequent(string[] words, int k) {
        // loop through to find occurances
        // store the pair of word(K) and freq(V) in to map and the words in a list
		// sort the words using comparator
        var map = new Dictionary<string, int>();
        var allwords = new List<string>();

        foreach (string word in words)
        {
            if (!map.ContainsKey(word))
            {
                map.Add(word, 0);
                allwords.Add(word);
            }

            map[word]++;
        }

        // sort the array based on map
        allwords.Sort((x, y) => map[x].CompareTo(map[y]) != 0 ? map[y].CompareTo(map[x]) : x.CompareTo(y));
        return allwords.Take(k).ToList();
    }
}
