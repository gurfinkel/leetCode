class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return n - l;
    }
}
