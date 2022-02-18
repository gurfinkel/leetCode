class Solution {
    public int maxLength(int[] ribbons, int k) {
        int left = 0;
        int right = Integer.MIN_VALUE;

        for (int ribbon : ribbons) {
            right = Math.max(right, ribbon);
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (canCut(ribbons, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (canCut(ribbons, k, right)) {
            return right;
        }

        return left;
    }

    boolean canCut(int[] ribbons, int k, int length) {
        for (int ribbon : ribbons) {
            k -= ribbon/length;

            if (0 >= k) {
                return true;
            }
        }

        return false;
    }
}
