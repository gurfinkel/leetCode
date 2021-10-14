class Solution {
    public int numSquares(int n) {
        // four-square and three-square theorems.
        while (0 == n % 4) {
            n /= 4;
        }

        if (7 == n % 8) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }

        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; n >= i * i; ++i) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        // bottom case of three-square theorem.
        return 3;
    }

    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }
}
