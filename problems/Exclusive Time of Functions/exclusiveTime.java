class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int prevTime = 0;

        while (logs.size() > idx) {
            String[] items = logs.get(idx++).split(":");
            int id = Integer.parseInt(items[0]);
            int time = Integer.parseInt(items[2]);

            if (items[1].equals("start")) {
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
