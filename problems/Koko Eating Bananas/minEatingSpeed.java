class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1_000_000_000;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (!possible(piles, h, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public boolean possible(int[] piles, int hours, int speed) {
        int time = 0;

        for (int pile : piles) {
            time += 1 + (pile - 1) / speed;
        }

        return hours >= time;
    }
}
