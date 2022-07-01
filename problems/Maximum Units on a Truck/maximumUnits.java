class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        PriorityQueue<int[]> store = new PriorityQueue<>((a,b)->b[1]-a[1]);

        for (int[] boxType : boxTypes) {
            store.add(boxType);
        }

        while (!store.isEmpty()) {
            int[] boxType = store.poll();
            int boxCount = Math.min(truckSize, boxType[0]);

            result += boxCount * boxType[1];
            truckSize -= boxCount;

            if (0 == truckSize) {
                break;
            }
        }

        return result;
    }
}
