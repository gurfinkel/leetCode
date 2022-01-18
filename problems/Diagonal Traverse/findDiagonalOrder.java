class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int n = rows * cols;
        int[] result = new int[n];
        int idx = 0;
        HashMap<Integer, List<Integer>> store = new HashMap<>();

        for (int row = 0; rows > row; ++row) {
            for (int col = 0; cols > col; ++col) {
                if (!store.containsKey(row + col)) {
                    store.put(row + col, new ArrayList<>());
                }
                store.get(row + col).add(mat[row][col]);
            }
        }

        for (int num = 0; rows + cols - 2 >= num; ++num) {
            List<Integer> items = store.get(num);

            if (1 != (num&1)) {
                Collections.reverse(items);
            }

            for (int item : items) {
                result[idx++] = item;
            }
        }

        return result;
    }
}
