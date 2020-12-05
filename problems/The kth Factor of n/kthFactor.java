class Solution {
    public int kthFactor(int n, int k) {
        int result = 1;
        int count = 1;

        while (k > count && n >= result++) {
            if (0 == n % result) {
                ++count;
            }
        }

        return k == count ? result : -1;
    }
}
