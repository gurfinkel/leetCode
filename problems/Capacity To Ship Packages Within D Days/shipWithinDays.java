class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            right += weight;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (checkShipCapacity(weights, days, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    boolean checkShipCapacity(int[] weights, int days, int shipCapacity) {
        int capacity = shipCapacity;

        for (int weight : weights) {
            if (capacity >= weight) {
                capacity -= weight;
            } else {
                --days;
                capacity = shipCapacity - weight;
            }

            if (0 > capacity || 0 == days) {
                return false;
            }
        }

        return true;
    }
}
