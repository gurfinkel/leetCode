public class Solution {
    public bool IsStrobogrammatic(string num) {
        var store = new Dictionary<int, int> {{0,0},{1,1},{6,9},{8,8},{9,6}};
        var origin = 0;
        var rotated = 0;
        var tens = 1;

        foreach (var digit in num) {
            if (store.ContainsKey(digit - '0')) {
                rotated = 10 * rotated + store[digit - '0'];
                origin = tens * (digit - '0') + origin;
                tens *= 10;
            } else {
                return false;
            }
        }

        return origin == rotated;
    }
}
