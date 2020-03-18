public class Solution {
    public IList<IList<int>> PalindromePairs(string[] words) {
        Trie trie = new Trie();
        int? emptyIdx = null;
        for (int i = 0; i < words.Length; i++)
        {
            if (words[i] == string.Empty)
            {
                emptyIdx = i;
            }

            trie.AddValue(ReverseWord(words[i]), i);
        }

        ISet<(int a, int b)> res = new HashSet<(int a, int b)>();

        for (int i = 0; i < words.Length; i++)
        {
            var w = words[i];
            if (w != string.Empty)
            {
                trie.Search(ref w, i, res);
                var rev = ReverseWord(w);

                if (rev == w && emptyIdx.HasValue)
                {
                    res.Add((i, emptyIdx.Value));
                    res.Add((emptyIdx.Value, i));
                }
            }
        }

        return res.Select(t => (IList<int>)new List<int>(2) {t.a, t.b}).ToList();
    }

    private class TrieNode
    {
        public int Index = -1;
        public readonly Dictionary<char, TrieNode> Next = new Dictionary<char, TrieNode>();
    }

    public class Trie
    {
        private readonly TrieNode _root = new TrieNode();

        private void AddValue(TrieNode node, ref string val, int idx, int wordIndex)
        {
            if (idx == val.Length)
            {
                node.Index = wordIndex;
                return;
            }

            char c = val[idx];
            TrieNode nextNode = null;

            if (node.Next.ContainsKey(c))
            {
                nextNode = node.Next[c];
            }
            else
            {
                nextNode = new TrieNode();
                node.Next[c] = nextNode;
            }

            AddValue(nextNode, ref val, idx + 1, wordIndex);
        }

        public void AddValue(string val, int idx)
        {
            AddValue(_root, ref val, 0, idx);
        }

        private bool IsPalindrome(StringBuilder word)
        {
            int l = 0;
            int r = word.Length - 1;

            while (l < r)
            {
                if(word[l] != word[r])
                {
                    return false;
                }

                l++;
                r--;
            }

            return true;
        }

        private bool IsPalindrome(ref string word, int start)
        {
            int l = start;
            int r = word.Length - 1;

            while (l < r)
            {
                if (word[l] != word[r])
                {
                    return false;
                }

                l++;
                r--;
            }

            return true;
        }


        private void FindPostfixes(StringBuilder sb, TrieNode node, int wordIndex, ISet<(int a, int b)> res)
        {
            if (node.Index >= 0 && wordIndex != node.Index && IsPalindrome(sb))
            {
                res.Add((wordIndex, node.Index));
            }

            foreach (var c2n in node.Next)
            {
                sb.Append(c2n.Key);
                FindPostfixes(sb, c2n.Value, wordIndex, res);
                sb.Remove(sb.Length - 1, 1);
            }
        }

        private void Search(ref string word, int wordIdx, ISet<(int a, int b)> res, int charIdx, TrieNode node)
        {
            if (node.Index >= 0 && node.Index != wordIdx && charIdx < word.Length && IsPalindrome(ref word, charIdx))
            {
                res.Add((wordIdx, node.Index));
            }

            if(charIdx == word.Length)
            {
                FindPostfixes(new StringBuilder(), node, wordIdx, res);
                return;
            }

            var c = word[charIdx];
            if (!node.Next.ContainsKey(c))
            {
                return;
            }

            Search(ref word, wordIdx, res, charIdx + 1, node.Next[word[charIdx]]);
        }

        public void Search(ref string word, int wordIdx, ISet<(int a, int b)> res)
        {
            Search(ref word, wordIdx, res, 0, _root);
        }
    }

    private string ReverseWord(string w)
    {
        var cArr = w.ToCharArray();
        Array.Reverse(cArr);
        StringBuilder sb = new StringBuilder(cArr.Length);
        foreach (var c in cArr)
        {
            sb.Append(c);
        }
        return sb.ToString();
    }
}
