class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];

        if (1 == k) {
            return min(costs[0]);
        }

        for (int[] cost : costs) {
            int[] arr = new int[k];

            for (int idx = 0; k > idx; ++idx) {
                arr[idx] = cost[idx] + minExcept(dp, idx);
            }

            for (int idx = 0; k > idx; ++idx) {
                dp[idx] = arr[idx];
            }
        }

        return min(dp);
    }

    private int min(int[] arr) {
        int result = Integer.MAX_VALUE;

        for (int item : arr) {
            result = Math.min(result, item);
        }

        return result;
    }

    private int minExcept(int[] arr, int idx) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; arr.length > i; ++i) {
            if (idx != i) {
                result = Math.min(result, arr[i]);
            }
        }

        return result;
    }
}
