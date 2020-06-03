public class Solution {
    public int TwoCitySchedCost(int[][] costs) {
        var result = 0;
        var n = costs.Length;
        var peopleToA = n >> 1;
        var peopleToB = peopleToA;

        Array.Sort(costs, (a, b) => Math.Abs(a[0] - a[1]) - Math.Abs(b[0] - b[1]));

        while (0 < peopleToA || 0 < peopleToB) {
            --n;

            if (0 == peopleToB || (0 < peopleToA && costs[n][0] < costs[n][1])) {
                result += costs[n][0];
                --peopleToA;
            } else {
                result += costs[n][1];
                --peopleToB;
            }
        }

        return result;
    }
}
