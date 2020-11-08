class Solution {
    public int minCostToMoveChips(int[] position) {
        int oddCounter = 0;
        int evenCounter = 0;

        for (int item : position) {
            if (1 == (item&1)) {
                ++oddCounter;
            } else {
                ++evenCounter;
            }
        }

        return Math.min(oddCounter, evenCounter);
    }
}
