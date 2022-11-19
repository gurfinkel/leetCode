class Solution {
    public boolean isUgly(int n) {
        if (0 >= n) {
            return false;
        }

        while (1 < n) {
            if (0 == n%2) {
                n /= 2;
            } else if (0 == n%3) {
                n /= 3;
            } else if (0 == n%5) {
                n /= 5;
            } else {
                return false;
            }
        }

        return 1 == n;
    }
}
