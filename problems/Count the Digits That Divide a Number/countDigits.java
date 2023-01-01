class Solution {
    public int countDigits(int num) {
        int result = 0;
        int n = num;

        while (0 < n) {
            int digit = n % 10;

            if (0 == num % digit) {
                ++result;
            }

            n /= 10;
        }

        return result;
    }
}
