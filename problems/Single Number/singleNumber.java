class Solution {
    public int singleNumber(int[] nums) {
        int store = 0;

        for (int num : nums) {
            store ^= num;
        }

        return store;
    }
}
