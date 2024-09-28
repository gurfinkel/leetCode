class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] items = log.split(":");
            int id = Integer.parseInt(items[0]);
            int time = Integer.parseInt(items[2]);

            if ("start".equals(items[1])) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime - 1;
                }
                
                stack.add(id);
            } else {
                result[stack.pop()] += 1 + time - prevTime;
            }

            prevTime = time;
        }

        return result;
    }
}
