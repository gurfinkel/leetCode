class Solution {
    public void reverseWords(char[] s) {
        int spaceIdx = 0;

        reverse(s, 0, s.length - 1);

        for (int idx = 1; s.length > idx; ++idx) {
            if (' ' == s[idx]) {
                reverse(s, spaceIdx, idx - 1);
                spaceIdx = 1 + idx;
            }
        }

        reverse(s, spaceIdx, s.length - 1);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            ++left;
            --right;
        }
    }
}
