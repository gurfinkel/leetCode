class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);

        for (int num : nums) {
            minHeap.add(num);

            if (k < minHeap.size()) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
