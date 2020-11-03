public class Solution {
    public bool CanAttendMeetings(int[][] intervals) {
        Array.Sort(intervals, (a, b) => a[0] - b[0]);

        for (int idx = 1; intervals.Length > idx; ++idx) {
            if (intervals[idx - 1][1] > intervals[idx][0]) {
                return false;
            }
        }

        return true;
    }
}
