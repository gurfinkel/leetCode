class Solution {
    public int minStoneSum(int[] piles, int k) {
        int result = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        for (int pile : piles) {
            maxHeap.add(pile);
        }

        while (0 < k && !maxHeap.isEmpty()) {
            maxHeap.add((int) Math.ceil(maxHeap.poll() / 2.0));
            --k;
        }

        while (!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }

        return result;
    }
}
