class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int idx = 0;

        // walk up
        while (1 + idx < n && arr[idx] < arr[1 + idx]) {
            ++idx;
        }

        // peak can't be first or last
        if (0 == idx || n - 1 == idx) {
            return false;
        }

        // walk down
        while (n > 1 + idx && arr[idx] > arr[1 + idx]) {
            ++idx;
        }

        return n - 1 == idx;
    }
}
