class Solution {
    public String reverseWords(String s) {
        String[] store = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; store.length > idx; ++idx) {
            String str = store[idx];
            int n = str.length();

            if (0 < idx) {
                sb.append(" ");
            }

            while (0 < n) {
                sb.append(str.charAt(--n));
            }
        }

        return sb.toString();
    }
}
