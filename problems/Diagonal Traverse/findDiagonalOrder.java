class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int n = rows * cols;
        int[] result = new int[n];
        HashMap<Integer, List<Integer>> diagonalIdxToValuesMap = new HashMap<>();
        
        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (!diagonalIdxToValuesMap.containsKey(row + col)) {
                    diagonalIdxToValuesMap.put(row + col, new ArrayList<>());
                }

                diagonalIdxToValuesMap.get(row + col).add(mat[row][col]);
            }
        }

        for (int diagonalIdx = 0, idx = 0; rows + cols - 1 > diagonalIdx; ++diagonalIdx) {
            List<Integer> items = diagonalIdxToValuesMap.get(diagonalIdx);
            int nextIdx = idx;

            idx += items.size();

            if (0 == diagonalIdx%2) {
                nextIdx += items.size() - 1;
            }

            for (int item : items) {
                result[nextIdx] = item;

                if (0 == diagonalIdx%2) {
                    --nextIdx;
                } else {
                    ++nextIdx;
                }
            }
        }

        return result;
    }
}
