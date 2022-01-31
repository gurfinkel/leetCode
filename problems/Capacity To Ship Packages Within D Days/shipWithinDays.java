class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;

        for (int weight : weights){
            right += weight;
        }

        while (left + 1 < right){
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (canShip(weights, days, right)) {
            return right;
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int remainCapacity = capacity;

        for (int weight : weights) {
            if (weight <= remainCapacity) {
                remainCapacity -= weight;
            } else {
                --days;
                remainCapacity = capacity - weight;

                if (0 > remainCapacity || 0 == days) {
                    return false;
                }
            }
        }

        return true;
    }
}
