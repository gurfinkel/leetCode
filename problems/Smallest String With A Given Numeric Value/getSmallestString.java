class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int position = n - 1; position >= 0; position--) {
            int add = Math.min(k - position, 26);
            result[position] = (char) (add + 'a' - 1);
            k -= add;
        }
        return new String(result);
    }
}
