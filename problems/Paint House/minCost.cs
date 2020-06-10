public class Solution {
    public int MinCost(int[][] costs) {
        int minRed = 0;
        int minBlue = 0;
        int minGreen = 0;

        foreach (var item in costs) {
            int red = item[0] + Math.Min(minBlue, minGreen);
            int blue = item[1] + Math.Min(minRed, minGreen);
            int green = item[2] + Math.Min(minBlue, minRed);
            minRed = red;
            minBlue = blue;
            minGreen = green;
        }

        return Math.Min(minRed, Math.Min(minBlue, minGreen));
    }
}
