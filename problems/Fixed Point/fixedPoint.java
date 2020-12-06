class Solution {
    public int fixedPoint(int[] A) {
        int left = 0;
        int right = A.length;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == mid && left < A[left]) {
                return mid;
            } else if (A[mid] < mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (A[left] == left) {
            return left;
        }

        if (right < A.length && A[right] == right) {
            return right;
        }

        return -1;
    }
}
