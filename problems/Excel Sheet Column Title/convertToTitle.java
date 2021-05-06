class Solution {
    public String convertToTitle(int columnNumber) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (0 < columnNumber) {
            stack.push((char)('A' + --columnNumber % 26));
            columnNumber /= 26;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
