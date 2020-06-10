public class Solution {
    public bool IsPowerOfTwo(int n) {
        if (0 >= n) {
            return false;
        }

        while (1 < n) {
            if (1 == (n & 1)) {
                return false;
            }
            n >>= 1;
        }

        return true;
    }
}
