public class Solution {
    public int FindJudge(int N, int[][] trust) {
        var store = new int[N];

        foreach (var item in trust) {
            ++store[item[1] - 1];
            --store[item[0] - 1];
        }

        for (var i = 0; N > i; ++i) {
            if (N - 1 == store[i]) {
                return 1 + i;
            }
        }

        return -1;
    }
}
