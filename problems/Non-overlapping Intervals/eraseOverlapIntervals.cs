public class Solution {
    public int EraseOverlapIntervals(int[][] intervals) {
        if (intervals.Length == 0)
        {
            return 0;
        }

        Array.Sort(intervals, (i1, i2) =>
        {
            var cmpEnd = i1[1].CompareTo(i2[1]);
            if (cmpEnd != 0)
            {
                return cmpEnd;
            }

            return i1[0].CompareTo(i2[0]);
        });

        int i = 0;
        int j = 1;
        int res = 0;

        while (i < intervals.Length)
        {
            int to = intervals[i][1];

            while (j < intervals.Length && intervals[j][0] < to)
            {
                j++;
                res++;
            }


            i = j;
            j = i + 1;
        }

        return res;
    }
}
