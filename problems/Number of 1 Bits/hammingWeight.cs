public class Solution {
    public int HammingWeight(uint n) {
        var result = 0;

        while (0 < n) {
            ++result;
            n &= (n - 1);
        }

        return result;
    }
}
