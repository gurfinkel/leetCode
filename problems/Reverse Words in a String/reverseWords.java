class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String item : s.split(" ")) {
            if (null != item && !"".equals(item)) {
                stack.push(item);
            }
        }

        while (!stack.isEmpty()) {
            if (0 != sb.length()) {
                sb.append(" ");
            }
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
