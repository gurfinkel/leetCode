class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; s.length() > idx; ++idx) {
            if (Character.isLetterOrDigit(s.charAt(idx))) {
                sb.append(Character.toLowerCase(s.charAt(idx)));
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            if (sb.charAt(left++) != sb.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
