public class Solution {
    public IList<string> FindWords(char[][] board, string[] words) {
        IList<(int i, int j)>[] char2Indices = new IList<(int i, int j)>[26];
        Trie trie = new Trie();
        int n = board.Length;
        if (n == 0)
        {
            return new List<string>();
        }

        int m = board[0].Length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                char2Indices[board[i][j] - 'a'] = char2Indices[board[i][j] - 'a'] ?? new List<(int i, int j)>();
                char2Indices[board[i][j] - 'a'].Add((i,j));
            }
        }

        foreach (var word in words)
        {
            trie.AddValue(word);
        }

        ISet<string> res = new HashSet<string>();
        trie.Search(res, board, new HashSet<(int i, int j)>(), char2Indices);
        return res.ToArray();
    }

    private static readonly (int di, int dj)[] _directions = { (0,1), (0,-1), (1,0), (-1,0)};

    private class TrieNode
    {
        public bool HasValue;
        public readonly Dictionary<char, TrieNode> Next = new Dictionary<char, TrieNode>();
    }

    private class Trie
    {
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

        public void AddValue(string val)
        {
            AddValue(_root, ref val, 0);
        }

        private void Search(TrieNode node, StringBuilder sb, ISet<string> res, (int i, int j)? coords, char[][] board, ISet<(int i, int j)> visited, IList<(int i, int j)>[] char2Indices)
        {
            if (coords.HasValue && !visited.Add(coords.Value))
            {
                return;
            }

            if (node.HasValue)
            {
                res.Add(sb.ToString());
            }

            if(coords.HasValue)
            {
                int n = board.Length;
                int m = board[0].Length;
                foreach (var dir in _directions)
                {
                    (int i, int j) newCoords = (coords.Value.i + dir.di, coords.Value.j + dir.dj);
                    if (newCoords.i >= 0 && newCoords.i < n && newCoords.j >= 0 && newCoords.j < m &&
                        node.Next.ContainsKey(board[newCoords.i][newCoords.j]))
                    {
                        sb.Append(board[newCoords.i][newCoords.j]);
                        Search(node.Next[board[newCoords.i][newCoords.j]], sb, res, newCoords, board, visited, char2Indices);
                        sb.Remove(sb.Length - 1, 1);
                    }
                }
            }
            else
            {
                foreach (var pair in node.Next)
                {
                    var c = pair.Key;
                    var next = pair.Value;

                    if (char2Indices[c - 'a'] != null)
                    {
                        foreach (var rc in char2Indices[c - 'a'])
                        {
                            sb.Append(c);
                            Search(next, sb, res, rc, board, visited, char2Indices);
                            sb.Remove(sb.Length - 1, 1);
                        }
                    }
                }
            }

            if (coords.HasValue)
            {
                visited.Remove(coords.Value);
            }
        }

        public void Search(ISet<string> res, char[][] board, ISet<(int i, int j)> visited, IList<(int i, int j)>[] char2Indices)
        {
            Search(_root, new StringBuilder(), res, null, board, visited, char2Indices);
        }
    }
}
