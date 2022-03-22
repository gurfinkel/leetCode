class Solution {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null
            || start.length() != end.length()) {
            return false;
        }

        int startIdx = 0;
        int endIdx = 0;

        while (start.length() > startIdx || end.length() > endIdx) {
            while (start.length() > startIdx && 'X' == start.charAt(startIdx)) {
                ++startIdx;
            }
            while (end.length() > endIdx && 'X' == end.charAt(endIdx)) {
                ++endIdx;
            }

            if (start.length() <= startIdx || end.length() <= endIdx) {
                break;
            }

            // relative order for 'R' and 'L' in two strings should be the same
            if (start.charAt(startIdx) != end.charAt(endIdx)) {
                return false;
            }
            // R can only move to right
            if ('R' == start.charAt(startIdx) && startIdx > endIdx) {
                return false;
            }
            // L can only move to left
            if ('L' == start.charAt(startIdx) && startIdx < endIdx) {
                return false;
            }

            ++startIdx;
            ++endIdx;
        }

        return startIdx == endIdx;
    }
}
