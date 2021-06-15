class Solution {
    public double myPow(double x, int n) {
        if (0 > n) {
            x = 1/x;
            n = -n;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (0 == n) {
            return 1.0;
        }

        double result = fastPow(x, n/2);

        if (1 == (n&1)) {
            return result * result * x;
        } else {
            return result * result;
        }
    }
}
