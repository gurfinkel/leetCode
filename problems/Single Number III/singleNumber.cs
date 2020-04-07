public class Solution {
    public int[] SingleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;

        foreach (var num in nums)
            bitmask ^= num;

        // rightmost 1-bit diff between x and y
        var diff = bitmask & (-bitmask);

        int x = 0;

        // bitmask which will contain only x
        foreach (var num in nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[]{x, bitmask^x};
    }
}
