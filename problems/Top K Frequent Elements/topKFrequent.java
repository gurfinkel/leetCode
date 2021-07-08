class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int num : nums) {
            store.put(num, 1 + store.getOrDefault(num, 0));
        }

        for (int key : store.keySet()) {
            minHeap.add(new int[] {key, store.get(key)});

            if (k < minHeap.size()) {
                minHeap.poll();
            }
        }

        int[] result = new int[minHeap.size()];

        for (int idx = result.length - 1; 0 <= idx; --idx) {
            result[idx] = minHeap.poll()[0];
        }

        return result;
    }
}
