class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (3 > arr.length) {
            return false;
        }

        for (int idx = 1; arr.length - 1 > idx; ++idx) {
            if (3 == ((arr[idx - 1] & 1) + (arr[idx] & 1) + (arr[1 + idx] & 1))) {
                return true;
            }
        }

        return false;
    }
}
