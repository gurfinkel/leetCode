class Solution {
    public boolean isNumber(String s) {
        if (null == s || 0 == s.length()) {
            return false;
        }

        boolean number = false;
        boolean sign = false;
        boolean decimal = false;
        boolean exp = false;

        s = s.trim();

        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            char ch = s.charAt(l++);

            if ('+' == ch || '-' == ch) {
                if (number || sign) {
                    return false;
                }

                sign= true;
            } else if ('0' <= ch && '9' >= ch) {
                number= true;
            } else if ('.' == ch) {
                if (decimal || exp) {
                    return false;
                }

                decimal = true;
                sign = true;
            } else if ('e' == ch || 'E' == ch) {
                if (exp || !number) {
                    return false;
                }

                exp = true;
                sign = false;
                number = false;
            } else {
                return false;
            }
        }

        return number;
    }
}
