class Solution {
    public boolean isNumber(String s) {
        boolean isSeenDot = false;
        boolean isSeenDigit = false;
        boolean isSeenSign = false;
        boolean isSeenExp = false;

        for (char symbol : s.toCharArray()) {
            if ('+' == symbol || '-' == symbol) {
                if (isSeenDigit || isSeenSign) {
                    return false;
                }

                isSeenSign = true;
            } else if ('0' <= symbol && '9' >= symbol) {
                isSeenDigit = true;
            } else if ('.' == symbol) {
                if (isSeenDot || isSeenExp) {
                    return false;
                }

                isSeenDot = true;
                isSeenSign = true;
            } else if ('e' == symbol || 'E' == symbol) {
                if (isSeenExp || !isSeenDigit) {
                    return false;
                }

                isSeenExp = true;
                isSeenSign = false;
                isSeenDigit = false;
            } else {
                return false;
            }
        }

        return isSeenDigit;
    }
}
