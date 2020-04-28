/**
 * // This is BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     public int Get(int x, int y) {}
 *     public IList<int> Dimensions() {}
 * }
 */

class Solution {
    public int LeftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        var result = -1;
        var dimensions = binaryMatrix.Dimensions();
        var row = 0;
        var col = dimensions[1] - 1;

        while (dimensions[0] > row && 0 <= col) {
            var cell = binaryMatrix.Get(row, col);

            if (0 == cell) {
                ++row;
            } else {
                result = col;
                --col;
            }
        }


        return result;
    }
}
