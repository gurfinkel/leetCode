class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int S = -1;

        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] + A[j] < K) {
                    S = Math.max(S, A[i] + A[j]);
                }
            }
        }

        return S;
    }
}
