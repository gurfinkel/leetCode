class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int idx = -1;

        while (0 < n && flowerbed.length > ++idx) {
            if (0 == idx) {
                if ((1 == flowerbed.length && 0 == flowerbed[idx]) || (1 < flowerbed.length && 0 == flowerbed[idx] + flowerbed[1 + idx])) {
                    --n;
                    flowerbed[idx] = 1;
                }
            } else if (flowerbed.length - 1 == idx) {
                if (0 == flowerbed[idx - 1] + flowerbed[idx]) {
                    --n;
                    flowerbed[idx] = 1;
                }
            } else if (0 == flowerbed[idx - 1] + flowerbed[idx] + flowerbed[1 + idx]) {
                --n;
                flowerbed[idx] = 1;
            }
        }

        return 0 == n;
    }
}
