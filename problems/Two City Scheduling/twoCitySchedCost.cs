public class Solution {
    public int TwoCitySchedCost(int[][] costs) {
        var sorted = costs.ToList();
        sorted.Sort((a, b) => Math.Abs(a[0] - a[1]) - Math.Abs(b[0] - b[1]));
        var minSum = 0;
        var a = costs.Length >> 1;
        var b = costs.Length >> 1;
        var idx = costs.Length - 1;

        while (0 < a || 0 < b) {
            if (0 == a) {
                minSum += sorted[idx--][1];
                --b;
            } else if (0 == b) {
                minSum += sorted[idx--][0];
                --a;
            } else {
                if (sorted[idx][0] < sorted[idx][1]) {
                    minSum += sorted[idx--][0];
                    --a;
                } else {
                    minSum += sorted[idx--][1];
                    --b;
                }
            }
        }

        return minSum;
    }
}
