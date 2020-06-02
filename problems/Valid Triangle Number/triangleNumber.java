class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; n - 2 > i; ++i) {
            int k = i + 2;

            for (int j = i + 1; n - 1 > j && 0 != nums[i]; ++j) {
                while (n > k && nums[i] + nums[j] > nums[k]) {
                    ++k;
                }

                result += k - j - 1;
            }
        }

        return result;
    }
}
