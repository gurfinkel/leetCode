class KthLargest {

    public KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>((a,b)->a-b);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (size == minHeap.size()) {
            int min = minHeap.poll();

            minHeap.add(Math.max(val, min));
        } else {
            minHeap.add(val);
        }

        return minHeap.peek();
    }

    private final int size;
    private final PriorityQueue<Integer> minHeap;
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
