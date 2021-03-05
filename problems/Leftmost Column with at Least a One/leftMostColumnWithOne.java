/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int idx = 0;

        if (checkColumn(binaryMatrix, rows, idx)) {
            return idx;
        } else {
            ++idx;
        }

        while (cols > idx) {
            if (!checkColumn(binaryMatrix, rows, idx)) {
                idx <<= 1;
            } else {
                break;
            }
        }

        if (cols > idx) {
            int left = (idx >> 1);
            int right = idx;

            while (left + 1 < right) {
                int mid = left + ((right - left) >> 1);
                boolean currRow = checkColumn(binaryMatrix, rows, mid);

                if (currRow && !checkColumn(binaryMatrix, rows, mid - 1)) {
                    return mid;
                } else if (!currRow) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            if (checkColumn(binaryMatrix, rows, left)) {
                return left;
            }

            if (checkColumn(binaryMatrix, rows, right)) {
                return right;
            }
        }

        return -1;
    }

    private int lowestRowWithOne = 0;

    private boolean checkColumn(BinaryMatrix binaryMatrix, int rows, int col) {
        for (int idx = lowestRowWithOne; rows > idx; ++idx) {
            if (1 == binaryMatrix.get(idx, col)) {
                lowestRowWithOne = idx;
                return true;
            }
        }

        return false;
    }
}
