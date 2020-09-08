public class Solution {
    public bool IsPowerOfFour(int num) {
        long test = 1;

        while (num >= test) {
            if (test == num) {
                return true;
            }

            test <<= 2;
        }

        return false;
    }
}
