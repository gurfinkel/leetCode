class Solution {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        int n = points.length;
        int i = 0;
        int j = 1;

        if (0 == n) {
            return 0;
        }

        Arrays.sort(points, (a,b)->
        {
            if (0 == Integer.compare(a[0], b[0])) {
                return Integer.compare(a[1],b[1]);
            } else {
                return Integer.compare(a[0],b[0]);
            }
        });

        while (n > i) {
            int to = points[i][1];

            while (n > j && points[j][0] <= to) {
                to = Math.min(to, points[j][1]);
                ++j;
            }

            ++result;
            i = j;
            j = i + 1;
        }

        return result;
    }
}
