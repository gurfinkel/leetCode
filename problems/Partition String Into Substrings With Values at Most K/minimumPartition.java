class Solution {
    public int minimumPartition(String s, int k) {
        int result = 1;
        int n = s.length();
        long num = 0;

        for(int idx = 0; n > idx; ++idx) {
            int digit = s.charAt(idx) - '0';

            if (k < digit) {
                return -1;
            } else if(k < 10 * num + digit) {
                ++result;
                num = digit;
            } else {
                num = 10 * num + digit;
            }
        }

        return result;
    }
}
