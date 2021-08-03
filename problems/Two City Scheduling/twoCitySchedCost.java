class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int result = 0;
        int n = costs.length / 2;

        Arrays.sort(costs, (a, b) ->
            (a[0] - a[1]) - (b[0] - b[1])
        );

        for (int idx = 0; n > idx; ++idx) {
            result += costs[idx][0] + costs[n + idx][1];
        }

        return result;
    }
}
