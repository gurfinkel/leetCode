class Solution {
    public int numOfPairs(String[] nums, String target) {
        int result = 0;

        for (int i = 0; nums.length > 1 + i; ++i) {
            for (int j = 1 + i; nums.length > j; ++j) {
                if (target.equals(nums[i] + nums[j])) {
                    ++result;
                }
                if (target.equals(nums[j] + nums[i])) {
                    ++result;
                }
            }
        }

        return result;
    }
}
