public class Solution {
    public bool IsPerfectSquare(int num) {
        if (2 > num) {
            return true;
        }

        long x = num >> 1;

        while (num < x * x) {
            x = (x + num / x) >> 1;
        }

        return (num == x * x);
    }
}
