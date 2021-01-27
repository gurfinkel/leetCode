class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> store = new HashMap<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                store.putIfAbsent(row - col, new PriorityQueue<>());
                store.get(row - col).add(mat[row][col]);
            }
        }

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                mat[row][col] = store.get(row - col).poll();
            }
        }

        return mat;
    }
}
