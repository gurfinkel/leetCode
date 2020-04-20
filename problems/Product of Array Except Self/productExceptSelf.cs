public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        var n = nums.Length;
        var suffixProd = 1;
        var prefixProds = new int[n];

        prefixProds[0] = 1;

        for (var i = 1; n > i; ++i) {
            prefixProds[i] = prefixProds[i - 1] * nums[i - 1];
        }

        for (var i = n - 1; 0 <= i; --i) {
            prefixProds[i] *= suffixProd;
            suffixProd *= nums[i];
        }

        return prefixProds;
    }
}
