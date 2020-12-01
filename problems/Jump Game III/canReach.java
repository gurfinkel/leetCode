class Solution {
    public boolean canReach(int[] arr, int start) {
        if (0 <= start && arr.length > start && 0 <= arr[start]) {
            if (0 == arr[start]) {
                return true;
            }

            arr[start] = -arr[start];

            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }

        return false;
    }
}
