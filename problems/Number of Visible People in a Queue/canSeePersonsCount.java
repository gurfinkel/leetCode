class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int idx = n - 1; 0 <= idx; --idx) {
            int count = 0;

            while (!stack.isEmpty() && stack.peek() < heights[idx]) {
                stack.pop();
                ++count;
            }

            if (!stack.isEmpty()) {
                ++count;
            }

            result[idx] = count;
            stack.add(heights[idx]);
        }

        return result;
    }
}
