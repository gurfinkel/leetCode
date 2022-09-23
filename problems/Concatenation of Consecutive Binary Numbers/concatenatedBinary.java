class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        int length = 0; // bit length of addends
        long result = 0; // long accumulator
        for (int i = 1; i <= n; i++) {
            // when meets power of 2, increase the bit length
            if ((i & (i - 1)) == 0) {
                length++;
            }
            result = ((result << length) | i) % MOD;
        }
        return (int) result;
    }
}
