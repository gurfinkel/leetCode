class Solution {
    public int numSub(String s) {
        int result = 0;
        int count = 0;
        int mod = (int)1e9 + 7;

        for (int i = 0; i < s.length(); ++i) {
            count = '1' == s.charAt(i) ? 1 + count : 0;
            result = (result + count) % mod;
        }

        return result;
    }
}
