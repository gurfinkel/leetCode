class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 0;
        long right = num;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
