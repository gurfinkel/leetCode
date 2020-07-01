public class Solution {
    public int ArrangeCoins(int n) {
        return (int)(Math.Sqrt(2 * (long)n + 0.25) - 0.5);
    }
}
