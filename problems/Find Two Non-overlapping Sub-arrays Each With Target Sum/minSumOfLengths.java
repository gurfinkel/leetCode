class Solution {
    /*
     * Idea: Use sliding window to figure out subarrays that add up to target.
     *       As we go, we want to store in "dp" the length of the shortest
     *       subarray we've seen up to the current "right" index. Every time
     *       we find a new subarray, we add its length to the length of the
     *       shortest non-overlapping subarray to its left (i.e. dp[left - 1].
     *       We will try to minimize this computation as we go (variable
     *       "result").
     */
    public int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int dp[] = new int[arr.length];
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int currentLength = right - left + 1;
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    // If we found an subarray to the left that does not overlap
                    // with the current subarray
                    result = Math.min(
                            result,
                            currentLength + dp[left - 1]);
                }

                // store in dp[right] the smallest length we have seen so far
                dp[right] = Math.min(currentLength,
                        right == 0 ? Integer.MAX_VALUE : dp[right - 1]);
            } else {
                // copy value from previous index if current subarray does not
                // add up to target
                dp[right] = right == 0 ? Integer.MAX_VALUE : dp[right - 1];
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
