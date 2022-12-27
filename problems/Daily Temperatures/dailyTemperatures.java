class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int answerIdx = 0;

        for (int idx = n - 1; 0 <= idx; --idx) {
            answerIdx = idx;

            if (idx < n - 1) {
                if (temperatures[idx] == temperatures[1 + idx]) {
                    result[idx] = 0 == result[1 + idx] ? 0 : 1 + result[1 + idx];
                    continue;
                } else if (temperatures[idx] < temperatures[1 + idx]) {
                    result[idx] = 1;
                    continue;
                }
            }

            while (answerIdx < n && temperatures[idx] >= temperatures[answerIdx]) {
                ++answerIdx;
            }

            result[idx] = n == answerIdx ? 0 : answerIdx - idx;
        }

        return result;
    }
}
