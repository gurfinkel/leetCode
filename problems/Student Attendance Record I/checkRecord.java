class Solution {
    public boolean checkRecord(String s) {
        int aCounter = 0;

        for (int idx = 0; s.length() > idx; ++idx) {
            if ('A' == s.charAt(idx)) {
                ++aCounter;
                if (2 == aCounter) {
                    return false;
                }
            }

            if (1 < idx && 'L' == s.charAt(idx - 2) && 'L' == s.charAt(idx - 1) && 'L' == s.charAt(idx)) {
                return false;
            }
        }

        return true;
    }
}
