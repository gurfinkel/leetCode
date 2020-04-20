public class Solution {
    public int LeastInterval(char[] tasks, int n) {
        var taskFrequencies = new int[26];

        foreach (var task in tasks) {
            ++taskFrequencies[task - 'A'];
        }

        Array.Sort(taskFrequencies);

        var maxCoolingTimes = taskFrequencies[25] - 1;
        var idleSlotsCount = maxCoolingTimes * n;

        for (var i = 24; 0 <= i; --i) {
            idleSlotsCount -= Math.Min(taskFrequencies[i], maxCoolingTimes);
        }

        return Math.Max(0, idleSlotsCount) + tasks.Length;
    }
}
