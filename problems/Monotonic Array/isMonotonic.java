class Solution {
    public boolean isMonotonic(int[] A) {
        int comp = 0;

        for (int idx = 1; A.length > idx; ++idx) {
            if (0 == comp) {
                comp = A[idx - 1] - A[idx];
            } else if (0 < comp && A[idx - 1] < A[idx]) {
                return false;
            } else if (0 > comp && A[idx - 1] > A[idx]) {
                return false;
            }
        }

        return true;
    }
}
