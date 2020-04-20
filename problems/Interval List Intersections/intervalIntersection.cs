public class Solution {
    public int[][] IntervalIntersection(int[][] A, int[][] B) {
        var result = new List<int[]>();
        var aIdx = 0;
        var bIdx = 0;

        while (A.Length > aIdx && B.Length > bIdx) {
            var x = Math.Max(A[aIdx][0], B[bIdx][0]);
            var y = Math.Min(A[aIdx][1], B[bIdx][1]);

            if (x <= y) {
                result.Add(new [] {x, y});
            }

            if (A[aIdx][1] < B[bIdx][1]) {
                ++aIdx;
            } else {
                ++bIdx;
            }
        }

        return result.ToArray();
    }
}
