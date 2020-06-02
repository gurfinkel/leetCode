public class Solution {
    public int[][] KClosest(int[][] points, int K) {
        var N = points.Length;
        var dists = new int[N];

        for (var i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Array.Sort(dists);
        var distK = dists[K-1];

        var ans = new int[K][];
        var t = 0;

        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];

        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
