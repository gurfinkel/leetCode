class Solution {

    public Solution(int[] w) {
        int n = w.length;

        prefixSums = new int[1 + n];

        for (int idx = 0; n > idx; ++idx) {
            prefixSums[1 + idx] = prefixSums[idx] + w[idx];
        }
    }

    public int pickIndex() {
        return pickIndexBinarySearch();
        // return pickIndexLinearSearch();

    }

    int pickIndexBinarySearch() {
        int min = 0;
        int max = prefixSums[prefixSums.length - 1];
        int target = min + (int)(Math.random() * (max - min));
        int left = 0;
        int right = prefixSums.length;

        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);

            if (target >= prefixSums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    int pickIndexLinearSearch() {
        int min = 0;
        int max = prefixSums[prefixSums.length - 1];
        int target = min + (int)(Math.random() * (max - min));

        for (int idx = 0; prefixSums.length >= idx; ++idx) {
            if (target < prefixSums[idx]) {
                return idx - 1;
            }
        }

        return 0;
    }

    int[] prefixSums;
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
