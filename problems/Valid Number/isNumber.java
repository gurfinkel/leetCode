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

        for (char symbol : s.toCharArray()) {
            if ('+' == symbol || '-' == symbol) {
                if (number || sign) {
                    return false;
                }

                sign = true;
            } else if ('0' <= symbol && '9' >= symbol) {
                number = true;
            } else if ('.' == symbol) {
                if (decimal || exp) {
                    return false;
                }

                decimal = true;
                sign = true;
            } else if ('e' == symbol || 'E' == symbol) {
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
