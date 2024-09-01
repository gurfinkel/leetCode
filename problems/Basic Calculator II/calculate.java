class Solution {
    public int calculate(String s) {
        int result = 0;

        if (null == s || 0 == s.length()) {
            return result;
        }

        Stack<Integer> store = new Stack<>();
        int currNumber = 0;
        int currOperator = '+';

        for (int idx = 0; s.length() > idx; ++idx) {
            char symbol = s.charAt(idx);

            if (Character.isDigit(symbol)) {
                currNumber = (10 * currNumber) + (symbol - '0');
            } 
            if ((!Character.isDigit(symbol) && !Character.isWhitespace(symbol)) || s.length() == 1 + idx) {
                if ('+' == currOperator) {
                    store.push(currNumber);
                } else if ('-' == currOperator) {
                    store.push(-currNumber);
                } else if ('*' == currOperator) {
                    store.push(store.pop() * currNumber);
                } else if ('/' == currOperator) {
                    store.push(store.pop() / currNumber);
                }

                currOperator = symbol;
                currNumber = 0;
            }
        }

        while (!store.isEmpty()) {
            result += store.pop();
        }

        return result;
    }
}
