class Solution {

    public Solution(int[] w) {
        _n = w.length;
        _prefixSums = new int[1 + _n];

        for (int idx = 0; _n > idx; ++idx) {
            _prefixSums[1 + idx] = w[idx] + _prefixSums[idx];
        }
    }

    public int pickIndex() {
        int min = 0;
        int max = _prefixSums[_n];
        int target = min + (int)(Math.random() * (max - min));

        for (int idx = 0; _n >= idx; ++idx) {
            if (target < _prefixSums[idx]) {
                return idx - 1;
            }
        }

        return 0;
    }

    private int _n;
    private int[] _prefixSums;
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
