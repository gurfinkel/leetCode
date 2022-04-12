class Solution {
    public int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> store = new Stack();

        for (String token : ops) {
            if (token.equals("+")) {
                int top = store.pop();
                int newtop = top + store.peek();

                store.push(top);
                store.push(newtop);
            } else if (token.equals("C")) {
                store.pop();
            } else if (token.equals("D")) {
                store.push(2 * store.peek());
            } else {
                store.push(Integer.valueOf(token));
            }
        }


        while (!store.isEmpty()) {
            result += store.pop();
        }

        return result;
    }
}
