/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            int testResult = guess(mid);

            if (0 == testResult) {
                return mid;
            } else if (1 == testResult) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (0 == guess(left)) {
            return left;
        }

        return right;
    }
}
