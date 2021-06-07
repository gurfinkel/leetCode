class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);

        if (x < y) {
            return getSum(b, a);
        }

        int sign = a > 0 ? 1 : -1;

        if (0 <= a * b) {
            while (0 != y) {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
        } else {
            while (0 != y) {
                int answer = x ^ y;
                int borrow = ((~x) & y) << 1;
                x = answer;
                y = borrow;
            }
        }

        return x * sign;
    }
}
