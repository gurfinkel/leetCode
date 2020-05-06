public class Solution {
    public int Divide(int dividend, int divisor) {
        if (int.MinValue == dividend && -1 == divisor) {
            return int.MaxValue;
        }

        var negatives = 2;
        var quotient = 0;

        if (0 < dividend) {
            --negatives;
            dividend = -dividend;
        }

        if (0 < divisor) {
            --negatives;
            divisor = -divisor;
        }

        while (divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;

            while (value >= int.MinValue >> 1 && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }

            quotient += powerOfTwo;
            dividend -= value;
        }

        return 1 == negatives ? quotient : -quotient;
    }
}
