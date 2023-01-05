class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        int n = strs.length;
        int len = strs[0].length();

        for (int letterIdx = 0; len > letterIdx; ++letterIdx) {
            for (int rowIdx = 1; n > rowIdx; ++rowIdx) {
                if (strs[rowIdx - 1].charAt(letterIdx) > strs[rowIdx].charAt(letterIdx)) {
                    ++result;
                    break;
                }
            }
        }

        return result;
    }
}
