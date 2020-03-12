public class Trie {

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void Insert(string word) {
        AddValue(_root, ref word, 0);
    }

    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        return Search(_root, ref word, 0, true);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) {
        return Search(_root, ref prefix, 0, false);
    }

    private class TrieNode
    {
        public bool HasValue;
        public readonly Dictionary<char, TrieNode> Next = new Dictionary<char, TrieNode>();
    }

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

    private bool Search(TrieNode node, ref string val, int idx, bool exact)
    {
        if (idx == val.Length)
        {
            return node.HasValue || !exact;
        }

        char c = val[idx];

        if (node.Next.ContainsKey(c))
        {
            return Search(node.Next[c], ref val, idx + 1, exact);
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
