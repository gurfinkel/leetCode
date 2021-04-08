class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int sIdx = 0;
        int pIdx = 0;
        int starIdx = -1;
        int sTmpIdx = -1;

        while (sLen > sIdx) {
            if (pLen > pIdx && (s.charAt(sIdx) == p.charAt(pIdx) || '?' == p.charAt(pIdx))) {
                ++sIdx;
                ++pIdx;
            } else if (pLen > pIdx && '*' == p.charAt(pIdx)) {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                ++pIdx;
            } else if (-1 == starIdx) {
                return false;
            } else {
                sIdx = 1 + sTmpIdx;
                pIdx = 1 + starIdx;
                sTmpIdx = sIdx;
            }
        }

        while (pLen > pIdx) {
            if ('*' != p.charAt(pIdx++)) {
                return false;
            }
        }

        return true;
    }
}
