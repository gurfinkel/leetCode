class Solution {
    public int xorBeauty(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        return xor;
    }
}
