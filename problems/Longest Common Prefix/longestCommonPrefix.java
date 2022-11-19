class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for (int letterIdx = 0; strs[0].length() > letterIdx; ++letterIdx) {
            for (int strIdx = 1; strs.length > strIdx; ++strIdx) {
                if (letterIdx >= strs[strIdx].length() || strs[0].charAt(letterIdx) != strs[strIdx].charAt(letterIdx)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(letterIdx));
        }

        return sb.toString();
    }
}
