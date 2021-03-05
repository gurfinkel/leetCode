class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int suffixProd = 1;
        int[] prefixProds = new int[n];

        prefixProds[0] = 1;

        for (int idx = 1; n > idx; ++idx) {
            prefixProds[idx] = prefixProds[idx - 1] * nums[idx - 1];
        }

        for (int idx = n - 1; 0 <= idx; --idx) {
            prefixProds[idx] *= suffixProd;
            suffixProd *= nums[idx];
        }

        return prefixProds;
    }
}
