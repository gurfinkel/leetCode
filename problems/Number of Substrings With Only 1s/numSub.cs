public class Solution {
    public int NumSub(string s) {
        var mod = 1000000007;
        var result = 0;
        var count = 0;
        
        foreach (char letter in s) {
            count = '1' == letter ? 1 + count : 0;
            result = (result + count) % mod;
        }
        
        return result;
    }
}
