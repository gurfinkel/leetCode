class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        for (int idx = 1; intervals.length > idx; ++idx) {
            if (intervals[idx - 1][1] > intervals[idx][0]) {
                return false;
            }
        }

        return true;
    }
}
