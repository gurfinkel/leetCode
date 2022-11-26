class Solution {
    public int bestClosingTime(String customers) {
        int result = 0;
        int minPenalty = Integer.MAX_VALUE;
        int n = customers.length();
        int[] prefixSums = new int[1 + n];

        for (int idx = 0; n > idx; ++idx) {
            prefixSums[1 + idx] = prefixSums[idx] + ('Y' == customers.charAt(idx) ? 1 : 0);
        }

        for (int idx = 0; n >= idx; ++idx) {
            int prevN = idx - prefixSums[idx];
            int nextY = prefixSums[n] - prefixSums[idx];
            int penalty = prevN + nextY;

            if (minPenalty > penalty) {
                minPenalty = penalty;
                result = idx;
            }
        }

        return result;
    }
}
