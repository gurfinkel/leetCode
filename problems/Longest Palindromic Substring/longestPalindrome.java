class Solution {
    public String longestPalindrome(String s) {
        if (null == s || 0 == s.length()) {
            return "";
        }

        int startIdx = 0;
        int endIdx = 0;

        for (int idx = 0; s.length() > idx; ++idx) {
            int len1 = expandAroundCenter(s, idx, idx);
            int len2 = expandAroundCenter(s, idx, 1 + idx);
            int len = Math.max(len1, len2);

            if (len > 1 + endIdx - startIdx) {
                startIdx = idx - ((len - 1) >> 1);
                endIdx = idx + (len >> 1);
            }
        }

        return s.substring(startIdx, 1 + endIdx);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (0 <= left && s.length() > right && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        return right - left - 1;
    }
}
