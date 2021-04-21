class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Dsu dsu = new Dsu(n);
        int result = n;

        for (int i = 0; n - 1 > i; ++i) {
            for (int j = 1 + i; n > j; ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    if (dsu.union(i, j)) {
                        --result;
                    }

                    if (1 == result) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public boolean isSimilar(String word1, String word2) {
        int diff = 0;

        for (int idx = 0; word1.length() > idx; ++idx) {
            if (word1.charAt(idx) != word2.charAt(idx)) {
                ++diff;
            }
            if (3 == diff) {
                return false;
            }
        }

        return true;
    }

    class Dsu {
        int[] _parents;
        int[] _ranks;

        public Dsu(int n) {
            _parents = new int[n];
            _ranks = new int[n];

            for (int idx = 0; n > idx; ++ idx) {
                _parents[idx] = idx;
            }
        }

        public int find(int x) {
            if (x != _parents[x]) {
                _parents[x] = find(_parents[x]);
            }

            return _parents[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }

            if (_ranks[px] > _ranks[py]) {
                _parents[py] = px;
                ++_ranks[px];
            } else {
                _parents[px] = py;
                ++_ranks[py];
            }

            return true;
        }
    }
}
