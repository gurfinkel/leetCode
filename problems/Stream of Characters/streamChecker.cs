public class StreamChecker {

    public StreamChecker(string[] words) {
        foreach (var s in words) {
            TreeNode cur = root;
            for (int j = s.Length - 1; j >= 0; j--) {  // save word in reverse by converting each letter a index
                int i = s[j] - 'a';
                if (cur.Children[i] == null) cur.Children[i] = new TreeNode();
                cur = cur.Children[i];
            }
            cur.EndOfWord = true;                      // at the first letter of each word set this flag to true
                                                       // and later use it to determine matching a word or not
        }
    }

    public bool Query(char letter) {
        _query.Add(letter);
        TreeNode cur = root;
        for (int i = _query.Count - 1; i >= 0; i--) {
            int j = _query[i] - 'a';
            if (cur.Children[j] == null) return false;
            cur = cur.Children[j];
            if (cur.EndOfWord) return true;
        }
        return false;
    }

    readonly TreeNode root = new TreeNode();
    readonly IList<char> _query = new List<char>();

    class TreeNode {
        public TreeNode[] Children = new TreeNode[26]; // we will only have letter a to z and we are going to converting
                                                       // letter to index by using letter - 'a'
        public bool EndOfWord = false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * bool param_1 = obj.Query(letter);
 */
