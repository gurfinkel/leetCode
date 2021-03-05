import java.util.AbstractMap;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Integer, int[]>> store = new PriorityQueue<>((a, b)->b.getKey()-a.getKey());
        int idx = 0;

        for (int[] item : points) {
            Map.Entry<Integer, int[]> entry =
    new AbstractMap.SimpleEntry<Integer, int[]>(item[0]*item[0]+item[1]*item[1], item);

            store.offer(entry);

            if (k < store.size()) {
                store.poll();
            }
        }

        int[][] result = new int[store.size()][2];

        while (!store.isEmpty()) {
            result[idx++] = store.poll().getValue();
        }

        return result;
    }
}
