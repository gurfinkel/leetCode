public class Trie {

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void Insert(string word) {
        var curr = root;

        foreach (var letter in word) {
            if (null == curr.children[letter - 'a']) {
                curr.children[letter - 'a'] = new TreeNode();
            }
            curr = curr.children[letter - 'a'];
        }

        curr.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        var curr = root;

        foreach (var letter in word) {
            if (null == curr.children[letter - 'a']) {
                return false;
            } else {
                curr = curr.children[letter - 'a'];
            }
        }

        return curr.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) {
        var curr = root;

        foreach (var letter in prefix) {
            if (null == curr.children[letter - 'a']) {
                return false;
            } else {
                curr = curr.children[letter - 'a'];
            }
        }

        return true;
    }

    private readonly TreeNode root = new TreeNode();

    class TreeNode {
        public TreeNode[] children = new TreeNode[26];
        public bool endOfWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
