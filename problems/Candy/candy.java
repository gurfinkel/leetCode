class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int n = ratings.length;
        int[] store = new int[n];

        for (int idx = 0; n > idx; ++idx) {
            store[idx] = 1;
        }

        for (int idx = 1; n > idx; ++idx) {
            if (ratings[idx - 1] < ratings[idx] && store[idx - 1] >= store[idx]) {
                store[idx] = 1 + store[idx - 1];
            }

        }

        for (int idx = n - 2; 0 <= idx; --idx) {
            if (ratings[idx] > ratings[1 + idx] && store[idx] <= store[1 + idx]) {
                store[idx] = 1 + store[1 + idx];
            }

        }

        for (int item : store) {
            result += item;
        }

        return result;
    }
}
