class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> result = new ArrayList<>();

        int idx = n;
        while (0 <= --idx || 0 < k) {
            if (0 <= idx) {
                k += num[idx];
            }

            result.add(0, k % 10);
            k /= 10;
        }

        return result;
    }
}
