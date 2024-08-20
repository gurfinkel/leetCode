class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int leftIdx = 0;
        int rightIdx = 0;

        while (nums.length >= rightIdx) {
            if (nums.length == rightIdx || 0 == nums[rightIdx]) {
                result = Math.max(result, rightIdx - leftIdx);
                leftIdx = 1 + rightIdx;
            }

            ++rightIdx;
        }

        return result;
    }
}
