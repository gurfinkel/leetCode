class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int result = 0;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] power2 = new int[n + 1];

        power2[0] = 1;

        for (int idx = 1; n >= idx; ++idx) {
            power2[idx] = (power2[idx - 1] << 1) % mod;
        }

        Arrays.sort(nums);

        while (left <= right) {
            if (target >= nums[left] + nums[right]) {
                result = (result + power2[right - left]) % mod;

                ++left;
            } else {
                --right;
            }
        }

        return result;
    }
}
