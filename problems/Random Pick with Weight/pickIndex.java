class Solution {

    public Solution(int[] w) {
        _prefixSums = new int[1 + w.length];

        for (int idx = 0; w.length > idx; ++idx) {
            _prefixSums[1 + idx] = w[idx] + _prefixSums[idx];
        }
    }

    public int pickIndex() {
        return pickIndexBinarySearch();
    }

    private int pickIndexBinarySearch() {
        int min = 0;
        int max = _prefixSums[_prefixSums.length - 1];
        int target = min + (int)(Math.random() * (max - min));
        int left = 0;
        int right = _prefixSums.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (target >= _prefixSums[mid]) {
                left = 1 + mid;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    private int pickIndexLinearSearch() {
        int min = 0;
        int max = _prefixSums[_prefixSums.length - 1];
        int target = min + (int)(Math.random() * (max - min));

        for (int idx = 0; _prefixSums.length >= idx; ++idx) {
            if (target < _prefixSums[idx]) {
                return idx - 1;
            }
        }

        return 0;
    }

    private int[] _prefixSums;
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
