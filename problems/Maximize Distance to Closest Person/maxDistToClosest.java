class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int zeros = 0;
        int endsZeros = 0;
        int maxZeros = 0;
        int idx = 0;

        while (n > idx && seats[idx++] == 0) {
            ++zeros;
        }

        endsZeros = zeros;
        idx = n - 1;
        zeros = 0;

        while (0 <= idx && seats[idx--] == 0) {
            ++zeros;
        }

        endsZeros = Math.max(endsZeros, zeros);
        zeros = 0;

        for (int seat : seats) {
            if (0 == seat) {
                ++zeros;
                maxZeros = Math.max(maxZeros, zeros);
            } else {
                zeros = 0;
            }
        }

        return Math.max(endsZeros, (maxZeros >> 1) + ((1 == (maxZeros&1)) ? 1 : 0));
    }
}
