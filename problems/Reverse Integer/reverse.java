class Solution {
    public int reverse(int x) {
        int result = 0;

        while (0 != x) {
            int digit = x % 10;
            x /= 10;

            if (willBeOverflow(result, digit)) {
                return 0;
            }

            result = 10 * result + digit;
        }

        return result;
    }

    private boolean willBeOverflow(int num, int digit) {
        if (Integer.MAX_VALUE / 10 < num || (Integer.MAX_VALUE / 10 == num && 7 < digit)) {
            return true;
        }

        if (Integer.MIN_VALUE / 10 > num || (Integer.MIN_VALUE / 10 == num && -8 > digit)) {
            return true;
        }

        return false;
    }
}
