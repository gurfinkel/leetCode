class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for (int[] item : updates) {
            int start = item[0];
            int end = item[1];
            int val = item[2];

            for (int idx = start; end >= idx; ++idx) {
                result[idx] += val;
            }
        }

        return result;
    }
}
