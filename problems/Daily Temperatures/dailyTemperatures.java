class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int idx = 0; n > idx; ++idx) {
            int temperature = temperatures[idx];

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperature) {
                int prevDay = stack.pop();
                
                result[prevDay] = idx - prevDay;
            }

            stack.push(idx);
        }
        
        return result;
    }
}
