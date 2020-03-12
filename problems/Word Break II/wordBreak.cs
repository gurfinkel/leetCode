public class Solution {
    public IList<string> WordBreak(string s, IList<string> wordDict) {
        IList<string>[] cache = new IList<string>[s.Length];
        ISet<string> set = wordDict.ToHashSet();
        var res = Helper(ref s, 0, cache, set);
        return res;
    }

    private IList<string> Helper(ref string s, int idx, IList<string>[] cache, ISet<string> set)
    {
        if (cache[idx] != null)
        {
            return cache[idx];
        }

        IList<string> res = new List<string>();

        for (int l = 1; l <= s.Length - idx; l++)
        {
            var word = s.Substring(idx, l);
            if (set.Contains(word))
            {
                var next = idx + l;
                if (next == s.Length)
                {
                    res.Add(word);
                }
                else
                {
                    var inner = Helper(ref s, next, cache, set);
                    foreach (var subsentence in inner)
                    {
                        res.Add($"{word} {subsentence}");
                    }
                }
            }
        }

        cache[idx] = res;
        return res;
    }
}
