class Solution {
    public int findKthPositive(int[] arr, int k) {
        int item = 1;
        int idx = 0;

        while (0 < k) {
            if (arr.length > idx && arr[idx] == item) {
                ++idx;
            } else {
                --k;
            }

            ++item;
        }

        return item - 1;
    }
}
