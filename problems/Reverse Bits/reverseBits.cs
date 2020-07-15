public class Solution {
    public uint reverseBits(uint n) {
        uint result = 0;

        for (int i = 0; 32 > i; ++i) {
            result += result + (n & 1);
            n >>= 1;
        }

        return result;
    }
}
