class Solution {
    public int missingNumber(int[] nums) {
        int rightSum = nums.length * (1 + nums.length) >> 1;
        int wrongSum = 0;

        for (int num : nums) {
            wrongSum += num;
        }

        return rightSum - wrongSum;
    }
}
