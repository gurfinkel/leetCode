class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int item : prices) {
            minPrice = Math.min(minPrice, item);
            maxProfit = Math.max(maxProfit, item - minPrice);
        }

        return maxProfit;
    }
}
