public class Solution {
    public int SingleNumber(int[] nums) {
        var seenOnce = 0;
        var seenTwice = 0;

        foreach (var item in nums) {
            seenOnce = ~seenTwice & (seenOnce ^ item);
            seenTwice = ~seenOnce & (seenTwice ^ item);
        }

        return seenOnce;
    }
}
