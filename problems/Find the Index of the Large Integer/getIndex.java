/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y]
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0;
        int right = reader.length() - 1;

        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            Boolean flag = 1 == ((right - left) & 1);
            int comparer = reader.compareSub(left, mid - (flag ? 0 : 1), mid + 1, right);

            if (0 == comparer) {
                return mid;
            } else if (-1 == comparer) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int lastTest = reader.compareSub(left, left, right, right);

        if (0 == lastTest) {
            return 1 + left;
        } else if (-1 == lastTest) {
            return right;
        } else {
            return left;
        }
    }
}
