public class Solution {
    public int HammingDistance(int x, int y) {
        var xor = x ^ y;
        var distance = 0;

        while (0 != xor) {
            xor &= (xor - 1);
            ++distance;
        }

        return distance;
    }
}
