/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            int value = reader.get(mid);

            if (target == value) {
                return mid;
            } else if (target > value) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (reader.get(left) == target) {
            return left;
        }

        if (reader.get(right) == target) {
            return right;
        }

        return -1;
    }
}
