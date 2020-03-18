public class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {
        _trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void AddWord(string word) {
        _trie.Insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public bool Search(string word) {
        return _trie.Search(word);
    }

    private class Trie
    {
        private class TrieNode
        {
            public bool HasValue;
            public readonly Dictionary<char, TrieNode> Next = new Dictionary<char, TrieNode>();
        }

        private readonly TrieNode _root = new TrieNode();

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


        public void Insert(string val)
        {
            AddValue(_root, ref val, 0);
        }

        private bool Search(TrieNode node, ref string val, int idx)
        {
            if (idx == val.Length)
            {
                return node.HasValue;
            }

            char c = val[idx];

            if (c == '.')
            {
                foreach (var nextNode in node.Next)
                {
                    if (Search(nextNode.Value, ref val, idx + 1))
                    {
                        return true;
                    }
                }

                return false;
            }

            if (node.Next.ContainsKey(c))
            {
                return Search(node.Next[c], ref val, idx + 1);
            }

            return false;
        }

        public bool Search(string val)
        {
            return Search(_root, ref val, 0);
        }
    }

    private readonly Trie _trie;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */
