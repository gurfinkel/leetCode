class Solution {
    public int minimumRecolors(String blocks, int k) {
        int result = 0;
        int counter = 0;

        for (int idx = 0; k > idx; ++idx) {
            if ('W' == blocks.charAt(idx)) {
                ++counter;
            }
        }

        result = counter;

        for (int idx = k; blocks.length() > idx; ++idx) {
            if ('W' == blocks.charAt(idx)) {
                ++counter;
            }
            if ('W' == blocks.charAt(idx - k)) {
                --counter;
            }
            result = Math.min(result, counter);
        }

        return result;
    }
}
