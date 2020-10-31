public class Solution {
    public double ChampagneTower(int poured, int query_row, int query_glass) {
        Double[,] store = new Double[101, 101];

        store[0, 0] = poured;

        for (int row = 0; query_row >= row; ++row) {
            for (int col = 0; row >= col; ++col) {
                double q = (store[row, col] - 1.0) / 2.0;

                if (0 < q) {
                    store[1 + row, col] += q;
                    store[1 + row, 1 + col] += q;
                }
            }
        }

        return Math.Min(1, store[query_row, query_glass]);
    }
}
