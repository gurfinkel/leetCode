class Solution {
    public int calculate(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        Queue<Character> store = new LinkedList<>();

        for (char token : s.toCharArray()) {
            store.add(token);
        }

        store.offer('&');

        return helper(store);
    }

    private int helper(Queue<Character> store) {
        int prevNum = 0;
        int sum = 0;
        int num = 0;
        char operator = '+';

        while (!store.isEmpty()) {
            char token = store.poll();

            if (Character.isDigit(token)) {
                num *= 10;
                num += token - '0';
            } else if ('(' == token) {
                num = helper(store);
            } else {
                if ('+' == operator) {
                    sum += prevNum;
                    prevNum = num;
                } else if ('-' == operator) {
                    sum += prevNum;
                    prevNum = -num;
                } else if ('*' == operator) {
                    prevNum *= num;
                } else if ('/' == operator) {
                    prevNum /= num;
                }

                if (')' == token) {
                    break;
                }

                operator = token;
                num = 0;
            }
        }

        return sum + prevNum;
    }
}
