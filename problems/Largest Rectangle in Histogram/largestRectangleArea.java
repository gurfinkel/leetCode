class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] extended = Arrays.copyOf(heights, n + 1);

        extended[n] = 0;

        for (int rightLowerIdx = 0; n >= rightLowerIdx; ++rightLowerIdx) {
            while (!stack.isEmpty() && extended[rightLowerIdx] < extended[stack.peek()]) {
                int idx = stack.pop();
                int height = extended[idx];
                int leftLowerIdx = stack.isEmpty() ? -1 : stack.peek();
                int width = rightLowerIdx - leftLowerIdx - 1;
                result = Math.max(result, height * width);
            }

            stack.push(rightLowerIdx);
        }

        return result;
    }
}
