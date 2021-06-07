class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequencies = new int[26];

        for (char task : tasks) {
            ++taskFrequencies[task - 'A'];
        }

        Arrays.sort(taskFrequencies);

        int maxCoolingTimes = taskFrequencies[25] - 1;
        int idleSlotsCount = maxCoolingTimes * n;

        for (int i = 24; 0 <= i; --i) {
            idleSlotsCount -= Math.min(taskFrequencies[i], maxCoolingTimes);
        }

        return Math.max(0, idleSlotsCount) + tasks.length;
    }
}
