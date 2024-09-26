class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        HashMap<Integer, Integer> outNumToCountMap = new HashMap<>();

        for (int idx = 0; k > idx; ++idx) {
            maxHeap.add(nums[idx]);
        }
        for (int idx = 0; (k / 2) > idx; ++idx) {
            minHeap.add(maxHeap.poll());
        }

        result[0] = (1 == (k&1)) ? maxHeap.peek() : 0.5*maxHeap.peek()  + 0.5*minHeap.peek();

        for (int idx = 0; n - k > idx; ++idx) {
            int outNum = nums[idx];
            int inNum = nums[idx + k];
            boolean outFromLeft = true;
            boolean inIntoLeft = true;
            
            outNumToCountMap.put(outNum, 1 + outNumToCountMap.getOrDefault(outNum, 0));
            
            if (maxHeap.peek() >= outNum) {
                outFromLeft = true;
            } else {
                outFromLeft = false;
            }

            if (maxHeap.peek() >= inNum) {
                maxHeap.add(inNum);
                inIntoLeft = true;
            } else {
                minHeap.add(inNum);
                inIntoLeft = false;
            }

            if (outFromLeft && !inIntoLeft) {
                maxHeap.add(minHeap.poll());
            } else if (!outFromLeft && inIntoLeft) {
                minHeap.add(maxHeap.poll());
            }
            
            while (0 < outNumToCountMap.getOrDefault(maxHeap.peek(), 0)) {
                outNumToCountMap.put(maxHeap.peek(), outNumToCountMap.get(maxHeap.poll()) - 1);
            }
            while (0 < outNumToCountMap.getOrDefault(minHeap.peek(), 0)) {
                outNumToCountMap.put(minHeap.peek(), outNumToCountMap.get(minHeap.poll()) - 1);
            }

            result[1 + idx] = (1 == (k&1)) ? maxHeap.peek() : 0.5*maxHeap.peek()  + 0.5*minHeap.peek();
        }

        return result;
    }
}
