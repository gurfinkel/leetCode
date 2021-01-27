class Solution {
    public int largestAltitude(int[] gain) {
        int result = 0;
        int curr = 0;

        for (int item : gain) {
            curr += item;
            result = Math.max(result, curr);
        }

        return result;
    }
}
