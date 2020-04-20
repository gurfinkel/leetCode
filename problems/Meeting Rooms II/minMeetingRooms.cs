public class Solution {
    public int MinMeetingRooms(int[][] intervals) {
        var n = intervals.Length;
        var starts = new int[n];
        var ends = new int[n];
        var sIdx = 0;
        var eIdx = 0;
        var currRoomsCount = 0;
        var roomsCount = 0;

        for (var i = 0; n > i; ++i) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Array.Sort(starts);
        Array.Sort(ends);

        while (n > sIdx) {
            if (starts[sIdx] < ends[eIdx]) {
                roomsCount = Math.Max(roomsCount, ++currRoomsCount);
                ++sIdx;
            } else {
                --currRoomsCount;
                ++eIdx;
            }
        }

        return roomsCount;
    }
}
