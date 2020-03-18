public class MagicDictionary {

    /** Initialize your data structure here. */
    public MagicDictionary() {
        _trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void BuildDict(string[] dict) {
        foreach (var word in dict) {
            _trie.AddValue(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public bool Search(string word) {
        return _trie.Search(word);
    }

    private readonly Trie _trie;

    private class TrieNode
    {
        public bool HasValue;
        public readonly Dictionary<char, TrieNode> Next = new Dictionary<char, TrieNode>();
    }

    private class Trie
    {
        private TrieNode _root = new TrieNode();

        private void AddValue(TrieNode node, ref string val, int idx)
        {
            if (idx == val.Length)
            {
                node.HasValue = true;
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

            AddValue(nextNode, ref val, idx + 1);
        }

        public void AddValue(string val)
        {
            AddValue(_root, ref val, 0);
        }

        private bool Search(TrieNode node, ref string val, int idx, bool modified)
        {
            if (idx == val.Length)
            {
                return node.HasValue && modified;
            }

            char c = val[idx];
            idx++;

            if (modified)
            {
                if (node.Next.ContainsKey(c))
                {
                    if(Search(node.Next[c], ref val, idx, true))
                    {
                        return true;
                    }
                }

                return false;
            }

            if (node.Next.ContainsKey(c) && Search(node.Next[c], ref val, idx, false))
            {
                return true;
            }

            foreach (var nextNode in node.Next)
            {
                if (nextNode.Key != c && Search(nextNode.Value, ref val, idx, true))
                {
                    return true;
                }
            }

            return false;
        }

        public bool Search(string val)
        {
            return Search(_root, ref val, 0, false);
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.BuildDict(dict);
 * bool param_2 = obj.Search(word);
 */
