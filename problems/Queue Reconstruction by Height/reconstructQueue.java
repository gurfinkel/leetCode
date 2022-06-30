class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] result = new int[n][2];
        List<int[]> store = new ArrayList<>();

        Arrays.sort(people, (a, b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] p : people){
            store.add(p[1], p);
        }

        for (int idx = 0; n > idx; ++idx) {
            result[idx] = store.get(idx);
        }

        return result;
    }
}
