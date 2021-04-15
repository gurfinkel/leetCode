class Solution {
    public int minSwaps(int[] data) {
        int result = Integer.MAX_VALUE;
        int ones = 0;
        int zeros = 0;

        for (int item : data) {
            ones += item;
        }

        for (int idx = 0; data.length > idx; ++idx) {
            zeros += 0 == data[idx] ? 1 : 0;
            zeros -= ones <= idx && 0 == data[idx - ones] ? 1 : 0;

            if (ones - 1 <= idx) {
                result = Math.min(result, zeros);
            }
        }

        return result;
    }
}
