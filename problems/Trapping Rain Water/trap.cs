public class Solution {
    public int Trap(int[] height) {
        int n = height.Length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        int result = 0;

        for (int idx = 0; n > idx; ++idx) {
            if (0 == idx || leftToRight[idx - 1] < height[idx]) {
                leftToRight[idx] = height[idx];
            } else {
                leftToRight[idx] = leftToRight[idx - 1];
            }

            if (0 == idx || rightToLeft[n - idx] < height[n - idx - 1]) {
                rightToLeft[n - idx - 1] = height[n - idx - 1];
            } else {
                rightToLeft[n - idx - 1] = rightToLeft[n - idx];
            }
        }

        for (int idx = 0; n > idx; ++idx) {
            result += Math.Min(leftToRight[idx], rightToLeft[idx]) - height[idx];
        }

        return result;
    }
}
