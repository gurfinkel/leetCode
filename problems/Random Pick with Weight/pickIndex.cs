public class Solution {

    public Solution(int[] w) {
        _weightSum = new int[w.Length];
        int max = 0;
        for (int i = 0; i < w.Length; i++)
        {
            max += w[i];
            _weightSum[i] = max;
        }
    }

    public int PickIndex() {
        int idx = _rnd.Next(0, _weightSum.Last()) + 1;
        int res = Array.BinarySearch(_weightSum, idx);
        return res >= 0 ? res : -res - 1;
    }

    private int[] _weightSum;
    private Random _rnd = new Random();
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.PickIndex();
 */
