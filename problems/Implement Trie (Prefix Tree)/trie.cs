public class Trie {

    private readonly TrieNode _root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void Insert(string word) {
        TrieNode currNode = _root;

        foreach (char letter in word) {
            if (!currNode.Children.ContainsKey(letter)) {
                currNode.Children[letter] = new TrieNode();
            }
            currNode = currNode.Children[letter];
        }

        currNode.IsEnd = true;
    }

    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        TrieNode currNode = _root;

        foreach (char letter in word) {
            if (!currNode.Children.ContainsKey(letter)) {
                return false;
            }
            currNode = currNode.Children[letter];
        }

        return currNode.IsEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string word) {
        TrieNode currNode = _root;

        foreach (char letter in word) {
            if (!currNode.Children.ContainsKey(letter)) {
                return false;
            }
            currNode = currNode.Children[letter];
        }

        return true;
    }

    private class TrieNode {
        public bool IsEnd {get; set;}
        public Dictionary<char, TrieNode> Children {get;set;} = new Dictionary<char, TrieNode>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
