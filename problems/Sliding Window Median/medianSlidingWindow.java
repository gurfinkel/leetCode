class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b, a));
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int idx = 0; k > idx; ++idx) {
            maxHeap.add(nums[idx]);
        }
        for (int idx = 0; (k >> 1) > idx; ++idx) {
            minHeap.add(maxHeap.poll());
        }

        result[0] = (1 == (k&1)) ? maxHeap.peek() : 0.5*maxHeap.peek()  + 0.5*minHeap.peek();

        for (int idx = 0; n - k > idx; ++idx) {
            int out_num = nums[idx];
            int in_num = nums[k + idx];
            int balance = (maxHeap.peek() >= out_num ? -1 : 1);

            store.put(out_num, 1 + store.getOrDefault(out_num, 0));

            if (maxHeap.peek() >= in_num) {
                ++balance;
                maxHeap.add(in_num);
            } else {
                --balance;
                minHeap.add(in_num);
            }

            if (0 > balance) {
                maxHeap.add(minHeap.poll());
                balance++;
            } else if (0 < balance) {
                minHeap.add(maxHeap.poll());
                balance--;
            }

            while (0 < store.getOrDefault(maxHeap.peek(), 0)) {
                store.put(maxHeap.peek(), store.get(maxHeap.poll()) - 1);
            }
            while (0 < store.getOrDefault(minHeap.peek(), 0)) {
                store.put(minHeap.peek(), store.get(minHeap.poll()) - 1);
            }

            result[1 + idx] = (1 == (k&1)) ? maxHeap.peek() : 0.5*maxHeap.peek()  + 0.5*minHeap.peek();
        }

        return result;
    }
}
