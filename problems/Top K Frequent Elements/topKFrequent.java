class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> valueToFrequency = new HashMap<>();

        for (int num : nums) {
            valueToFrequency.put(num, 1 + valueToFrequency.getOrDefault(num, 0));
        }

        for (int key : valueToFrequency.keySet()) {
            minHeap.add(new int[] {key, valueToFrequency.get(key)});

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
