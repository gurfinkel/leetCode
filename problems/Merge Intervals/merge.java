class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> store = new ArrayList<>();

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        for (int[] interval : intervals) {
            if (store.isEmpty() || store.get(store.size() - 1)[1] < interval[0]) {
                store.add(interval);
            } else {
                store.get(store.size() - 1)[1] = Math.max(store.get(store.size() - 1)[1], interval[1]);
            }
        }

        int[][] result = new int[store.size()][2];
        int idx = 0;

        for (int[] interval : store) {
            result[idx++] = interval;
        }

        return result;
    }
}
