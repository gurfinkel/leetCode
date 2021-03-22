class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int i = 0; mat.length > i; ++i) {
            for (int j = 0; mat[0].length > j; ++j) {
                store.put(mat[i][j], 1 + store.getOrDefault(mat[i][j], 0));
            }
        }

        for (int key : store.keySet()) {
            if (mat.length == store.get(key)) {
                return key;
            }
        }

        return -1;
    }
}
