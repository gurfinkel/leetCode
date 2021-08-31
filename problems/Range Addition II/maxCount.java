class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int maxRows = m;
        int maxCols = n;

        for (int[] item : ops) {
            maxRows = Math.min(maxRows, item[0]);
            maxCols = Math.min(maxCols, item[1]);
        }

        return maxRows * maxCols;
    }
}
