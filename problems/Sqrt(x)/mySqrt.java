class Solution {
    public int mySqrt(int x) {
        if (0 == x) {
            return 0;
        }

        int left = 1;
        int right = x;

        while (1 + left < right) {
            int mid = left + (right - left) / 2;

            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
