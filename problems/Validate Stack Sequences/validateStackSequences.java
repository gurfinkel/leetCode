class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> store = new Stack<>();
        int j = 0;

        for (int x: pushed) {
            store.push(x);

            while (!store.isEmpty() && n > j && store.peek() == popped[j]) {
                store.pop();
                ++j;
            }
        }

        return n == j;
    }
}
