class Solution {
    public int racecar(int target) {
        if (dp[target] > 0)
            return dp[target];
        int n = (int)(Math.log(target) / Math.log(2)) + 1;
        if (1 << n == target + 1) {
            dp[target] = n;
        } else {
            dp[target] = racecar((1 << n) - 1 - target) + n + 1;
            for (int m = 0; m < n - 1; ++m) {
                dp[target] = Math.min(dp[target], racecar(target - (1 << (n - 1)) + (1 << m)) + n + m + 1);
            }
        }
        return dp[target];
    }

    int[] dp = new int[10001];
}

/**
Consider two general cases for number i with bit_length n.

1. i==2^n-1, this case, n is the best way
2. 2^(n-1)-1<i<2^n-1, there are two ways to arrive at i:
    Use n A to arrive at 2^n-1 first, then use R to change the direction, by here there are n+1 operations (n A and one R), then the remaining is same as dp[2^n-1-i]
    Use n-1 A to arrive at 2^(n-1)-1 first, then R to change the direction, use m A to go backward, then use R to change the direction again to move forward, by here there are n-1+2+m=n+m+1 operations (n-1 A, two R, m A) , current position is 2^(n-1)-1-(2^m-1)=2^(n-1)-2^m, the remaining operations is same as dp[i-(2^(n-1)-1)+(2^m-1)]=dp[i-2^(n-1)+2^m)].
*/
