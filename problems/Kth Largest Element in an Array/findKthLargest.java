class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int item : nums) {
            minHeap.add(item);

            if (k < minHeap.size()) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
