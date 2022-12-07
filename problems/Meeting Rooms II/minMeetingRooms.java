class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int result = 0;
        int n = intervals.length;
        int[] ends = new int[n];
        int[] starts = new int[n];
        int eIdx = 0;
        int sIdx = 0;
        int rooms = 0;

        for (int idx = 0; n > idx; ++idx) {
            ends[idx] = intervals[idx][1];
            starts[idx] = intervals[idx][0];
        }

        Arrays.sort(ends);
        Arrays.sort(starts);

        while (n > sIdx) {
            if (starts[sIdx] < ends[eIdx]) {
                result = Math.max(result, ++rooms);
                ++sIdx;
            } else {
                --rooms;
                ++eIdx;
            }
        }

        return result;
    }
}
