class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> store = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                int second = store.pop();
                int first = store.pop();

                store.push(first + second);
            } else if ("-".equals(token)) {
                int second = store.pop();
                int first = store.pop();

                store.push(first - second);
            } else if ("*".equals(token)) {
                int second = store.pop();
                int first = store.pop();

                store.push(first * second);
            } else if ("/".equals(token)) {
                int second = store.pop();
                int first = store.pop();

                store.push(first / second);
            } else {
                store.push(Integer.parseInt(token));
            }
        }

        return store.pop();
    }
}
