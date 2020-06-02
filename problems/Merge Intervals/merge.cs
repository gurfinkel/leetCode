public class Solution {
    public int[][] Merge(int[][] intervals) {
        var n = intervals.Length;
        var starts = new List<int>();
        var ends = new List<int>();
        var sIndex = 0;
        var eIndex = 0;
        var counter = 0;
        var result = new List<int[]>();
        var currentInterval = new int[2];

        foreach (var item in intervals) {
            starts.Add(item[0]);
            ends.Add(item[1]);
        }

        starts.Sort();
        ends.Sort();

        while (n > eIndex) {
            if (0 == counter) {
                currentInterval[0] = starts[sIndex];
            }
            if (starts.Count > sIndex && starts[sIndex] <= ends[eIndex]) {
                ++counter;
                ++sIndex;
            } else {
                --counter;
                if (0 == counter) {
                    currentInterval[1] = ends[eIndex];
                    result.Add(currentInterval);
                    currentInterval = new int[2];
                }
                ++eIndex;
            }
        }

        return result.ToArray();
    }
}
