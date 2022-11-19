class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        int n = s.length();

        if (0 == n) {
            return 0;
        }

        boolean negative = '-' == s.charAt(0);
        boolean positive = '+' == s.charAt(0);
        int idx = negative || positive ? 1 : 0;
        long result = 0;

        while (n > idx && Character.isDigit(s.charAt(idx))) {
            result = 10 * result + (s.charAt(idx++) - '0');

            if (result > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return negative ? -(int)result : (int)result;
    }
}
