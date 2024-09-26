class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int idx = 0; arr.length > idx; ++idx) {
            if (arr[idx] <= k) {
                ++k;
            } else {
                break;
            }
        }

        return k;
    }
}
