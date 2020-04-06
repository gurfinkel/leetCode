public class Solution {
    public int MaxProfit(int[] prices) {
        var max = 0;

        for (var i = 1; prices.Length > i; ++i) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }
}
