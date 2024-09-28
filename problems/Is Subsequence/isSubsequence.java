class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        int tIdx = 0;

        while (s.length() > sIdx && t.length() > tIdx) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                ++sIdx;
            }
            ++tIdx;
        }

        return sIdx == s.length();
    }
}
