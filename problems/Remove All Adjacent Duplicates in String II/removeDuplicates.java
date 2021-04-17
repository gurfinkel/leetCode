class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> store = new Stack<>();

        for (int idx = 0; sb.length() > idx; ++idx) {
            if (0 == idx || sb.charAt(idx - 1) != sb.charAt(idx)) {
                store.push(1);
            } else {
                int count = 1 + store.pop();

                if (k == count) {
                    sb.delete(1 + idx - k, 1 + idx);
                    idx = idx - k;
                } else {
                    store.push(count);
                }
            }
        }

        return sb.toString();
    }
}
