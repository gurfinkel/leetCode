class Solution {
    public int connectSticks(int[] sticks) {
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            minHeap.add(stick);
        }

        while (!minHeap.isEmpty()) {
            int item = minHeap.poll();

            if (minHeap.isEmpty()) {
                break;
            } else {
                item += minHeap.poll();
                minHeap.add(item);
                result += item;
            }
        }

        return result;
    }
}
