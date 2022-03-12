class WordFilter {

    public WordFilter(String[] words) {
        root = new TrieNode();

        for (int idx = 0; words.length > idx; ++idx) {
            String word = words[idx] + "$";

            for (int i = 0; word.length() > i; ++i) {
                TrieNode node = root;

                node.idx = idx;

                for (int j = i; 2 * word.length() - 1 > j; ++j) {
                    char letter = word.charAt(j % word.length());

                    if (!node.children.containsKey(letter)) {
                        node.children.put(letter, new TrieNode());
                    }

                    node = node.children.get(letter);
                    node.idx = idx;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode node = root;

        for (char letter: (suffix + '$' + prefix).toCharArray()) {
            if (!node.children.containsKey(letter)) {
                return -1;
            }

            node = node.children.get(letter);
        }

        return node.idx;
    }

    TrieNode root;

    class TrieNode {
        HashMap<Character, TrieNode> children;
        int idx;

        public TrieNode() {
            children = new HashMap();
            idx = 0;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
