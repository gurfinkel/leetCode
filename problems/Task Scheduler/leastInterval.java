class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequencies = new int[26];

        for (char task : tasks) {
            ++taskFrequencies[task - 'A'];
        }

        Arrays.sort(taskFrequencies);

        int idleSlotsCounter = n * (taskFrequencies[25] - 1);

        for (int idx = 24; 0 <= idx; --idx) {
            idleSlotsCounter -= Math.min(taskFrequencies[idx], taskFrequencies[25] - 1);
        }

        return tasks.length + Math.max(0, idleSlotsCounter);
    }
}
