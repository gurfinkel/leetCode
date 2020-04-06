public class Solution {
    public int[] CountBits(int num) {
        var result = new int[1 + num];

        for (var i = 1; num >= i; ++i) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
