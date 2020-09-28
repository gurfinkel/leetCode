class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int result = 0;

        if (0 == n) {
            return result;
        }


        for (int idx = 0; n - 1 > idx; ++idx) {
            result += Math.min(timeSeries[1 + idx] - timeSeries[idx], duration);
        }

        return result + duration;
    }
}
