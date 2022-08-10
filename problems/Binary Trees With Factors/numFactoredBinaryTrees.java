class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        long result = 0;
        int n = arr.length;
        long[] dp = new long[n];
        HashMap<Integer, Integer> store = new HashMap();

        Arrays.fill(dp, 1);
        Arrays.sort(arr);

        for (int i = 0; n > i; ++i) {
            store.put(arr[i], i);
        }

        for (int i = 0; n > i; ++i)
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) { // A[j] is left child
                    int right = arr[i] / arr[j];
                    if (store.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[store.get(right)]) % MOD;
                    }
                }
            }



        for (long x: dp) {
            result += x;
        }

        return (int) (result % MOD);
    }
}
