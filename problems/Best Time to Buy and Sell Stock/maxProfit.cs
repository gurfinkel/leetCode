public class Solution {
    public int MaxProfit(int[] prices) {
        var minPrice = Int32.MaxValue;
        var maxProfit = 0;

        foreach (var item in prices) {
            minPrice = Math.Min(minPrice, item);
            maxProfit = Math.Max(maxProfit, item - minPrice);
        }

        return maxProfit;
    }
}
