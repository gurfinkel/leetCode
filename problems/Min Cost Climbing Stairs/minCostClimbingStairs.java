class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int downOne = 0;
        int downTwo = 0;

        for (int idx = 2; 1 + cost.length > idx; ++idx) {
            int tmp = downOne;

            downOne = Math.min(downOne + cost[idx - 1], downTwo + cost[idx - 2]);
            downTwo = tmp;
        }

        return downOne;
    }
}
