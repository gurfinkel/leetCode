class Solution {
    public void reverseString(char[] s) {
        int n = s.length;

        for (int idx = 0; n >> 1 > idx; ++idx) {
            char tmp = s[idx];
            s[idx] = s[n - idx - 1];
            s[n - idx - 1] = tmp;
        }
    }
}
