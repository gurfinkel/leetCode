public class Solution {
    public int CountSubstrings(string s, string t) {
        Trie trie = new Trie();
        int result = 0;

        for (int i = 0; t.Length > i; ++i) {
            for (int j = 1; t.Length - i >= j; ++j) {
                trie.AddWord(t.Substring(i,j));
            }
        }

        for (int i = 0; s.Length > i; ++i) {
            for (int j = 1; s.Length - i >= j; ++j) {
                for (int idx = 0; j > idx; ++idx) {
                    string subString = s.Substring(i,idx)+char.ToUpper(s[i+idx])+s.Substring(i+1+idx,j-idx-1);

                    result += trie.FindWord(subString);
                }
            }
        }

        return result;
    }
}

public class Trie {
    private class TrieNode {
        public int Counter {get;set;} = 0;
        public Dictionary<char, TrieNode> Children {get;set;} = new Dictionary<char, TrieNode>();
    }

    private readonly TrieNode _root = new TrieNode();

    private void AddWord(TrieNode node, ref string word, int idx = 0) {
        if (word.Length == idx) {
            ++node.Counter;

            return;
        }

        TrieNode nextNode = new TrieNode();

        if (node.Children.ContainsKey(word[idx])) {
            nextNode = node.Children[word[idx]];
        } else {
            node.Children[word[idx]] = nextNode;
        }

        AddWord(nextNode, ref word, 1 + idx);
    }

    public void AddWord(string word) {
        AddWord(_root, ref word);
    }

    private int FindWord(TrieNode node, ref string word, int idx = 0) {
        if (word.Length == idx) {
            return node.Counter;
        }

        if (char.IsUpper(word[idx])) {
            int counter = 0;

            foreach (var nextNode in node.Children) {
                if (char.ToLower(word[idx]) != nextNode.Key) {
                    counter += FindWord(nextNode.Value, ref word, 1 + idx);
                }
            }

            return counter;
        }

        if (node.Children.ContainsKey(word[idx])) {
            return FindWord(node.Children[word[idx]], ref word, 1 + idx);
        }

        return 0;
    }

    public int FindWord(string word) {
        return FindWord(_root, ref word);
    }
}
