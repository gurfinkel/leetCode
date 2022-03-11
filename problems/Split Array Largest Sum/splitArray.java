class Solution {
    public int splitArray(int[] nums, int m) {
        return splitArrayBottomUp(nums, m);
        // return splitArrayBs(nums, m);
    }

    public int splitArrayBottomUp(int[] nums, int m) {
        // Defined it as per the maximum size of array and split count
        // But can be defined with the input size as well
        int[][] memo = new int[1001][51];
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int idx = 0; n > idx; ++idx) {
            prefixSum[1 + idx] = prefixSum[idx] + nums[idx];
        }

        for (int subarrayCount = 1; subarrayCount <= m; subarrayCount++) {
            for (int currIndex = 0; currIndex < n; currIndex++) {
               // Base Case: If there is only one subarray left, then all of the remaining numbers
               // must go in the current subarray. So return the sum of the remaining numbers.
                if (subarrayCount == 1) {
                    memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
                    continue;
                }

                // Otherwise, use the recurrence relation to determine the minimum largest subarray
                // sum between currIndex and the end of the array with subarrayCount subarray remaining.
                int minimumLargestSplitSum = Integer.MAX_VALUE;
                for (int i = currIndex; i <= n - subarrayCount; i++) {
                    // Store the sum of the first subarray.
                    int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

                    // Find the maximum subarray sum for the current first split.
                    int largestSplitSum = Math.max(firstSplitSum, memo[i + 1][subarrayCount - 1]);

                    // Find the minimum among all possible combinations.
                    minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);

                    if (firstSplitSum >= minimumLargestSplitSum) {
                        break;
                    }
                }

                memo[currIndex][subarrayCount] = minimumLargestSplitSum;
            }
        }

        return memo[0][m];
    }

    public int splitArrayBs(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int item : nums) {
            left = Math.max(left, item);
            right += item;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (m >= minimumSubArraysRequired(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (m >= minimumSubArraysRequired(nums, left)) {
            return left;
        }

        return right;
    }

    private int minimumSubArraysRequired(int[] nums, int maxSumAllowed) {
        int sum = 0;
        int splitsRequired = 1;

        for (int item : nums) {
            if (maxSumAllowed >= sum + item) {
                sum += item;
            } else {
                sum = item;
                ++splitsRequired;
            }
        }

        return splitsRequired;
    }
}
