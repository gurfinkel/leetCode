class Solution {
    public int arrangeCoins(int n) {
        if (n < 2) {
            return n;
        }

        int left = 0;
        int right = n;

        while (left + 1 < right) {
          long mid = left + ((right - left) >> 1);

          if (mid * (mid + 1) >> 1 == n) {
              return (int)mid;
          } else if (n > mid * (mid + 1) >> 1) {
              left = (int)mid;
          } else {
              right = (int)mid;
          }
        }

        return left;
    }
}
