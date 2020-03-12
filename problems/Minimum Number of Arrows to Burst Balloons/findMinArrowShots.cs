public class Solution {
    public int FindMinArrowShots(int[][] points) {
        if (points.Length == 0)
        {
            return 0;
        }

        Array.Sort(points, (i1, i2) =>
        {
            var cmpEnd = i1[0].CompareTo(i2[0]);
            if (cmpEnd != 0)
            {
                return cmpEnd;
            }
            return i1[1].CompareTo(i2[1]);
        });

        int i = 0;
        int j = 1;
        int res = 0;

        while (i < points.Length)
        {
            int to = points[i][1];

            while (j < points.Length && points[j][0] <= to)
            {
                to = Math.Min(to, points[j][1]);
                j++;
            }

            res++;

            i = j;
            j = i + 1;
        }

        return res;
    }
}
