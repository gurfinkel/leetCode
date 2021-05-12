class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        // Preprocess the height of the warehouse rooms to get usable heights
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
        }

        // Iterate through boxes from smallest to largest
        Arrays.sort(boxes);

        int count = 0;

        for (int i = warehouse.length - 1; i >= 0; i--) {
            // Count the boxes that can fit in the current warehouse room
            if (count < boxes.length && boxes[count] <= warehouse[i]) {
                count++;
            }
        }

        return count;
    }
}
