class Solution {
    public int numberOfCuts(int n) {
        return 1 == n ? 0 : (0 == (n&1) ? n/2 : n);
    }
}
