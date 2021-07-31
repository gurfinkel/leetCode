class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;

        if (0 == n) {
            return result;
        }

        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];

        leftToRight[0] = height[0];
        rightToLeft[n - 1] = height[n - 1];

        for (int idx = 1; n > idx; ++idx) {
            leftToRight[idx] = Math.max(leftToRight[idx - 1], height[idx]);
            rightToLeft[n - 1 - idx] = Math.max(rightToLeft[n - idx], height[n - 1 - idx]);
        }

//         System.out.println(Arrays.stream(leftToRight)
//                  .mapToObj(String::valueOf)
//                  .collect(Collectors.joining(", ")));

//         System.out.println(Arrays.stream(rightToLeft)
//                  .mapToObj(String::valueOf)
//                  .collect(Collectors.joining(", ")));

        for (int idx = 0; n > idx; ++idx) {
            result += Math.min(leftToRight[idx], rightToLeft[idx]) - height[idx];
        }

        return result;
    }
}
