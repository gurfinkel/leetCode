public class Solution {
    public int ClimbStairs(int n) {
        var minusOne = 1;
        var minusTwo = 1;

        for (var i = 2; n >= i; ++i) {
            var curr = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = curr;
        }

        return minusOne;
    }
}
