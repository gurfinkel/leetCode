class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
        
        for (int[] point : points) {
            maxHeap.add(point);
            
            if (k < maxHeap.size()) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[maxHeap.size()][2];
        int idx = 0;
        
        while (!maxHeap.isEmpty()) {
            result[idx++] = maxHeap.poll();
        }
        
        return result;
    }
}
