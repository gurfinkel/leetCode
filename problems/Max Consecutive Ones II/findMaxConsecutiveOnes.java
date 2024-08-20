class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        int zeroCounter = 0;

        while (nums.length > rightIdx) {
            if (0 == nums[rightIdx]) {
                ++zeroCounter;
            }

            while (leftIdx <= rightIdx && 1 < zeroCounter) {
                if (0 == nums[leftIdx]) {
                    --zeroCounter;
                }

                ++leftIdx;
            }

            ++rightIdx;
            result = Math.max(result, rightIdx - leftIdx);
        }

        return result;
    }
}
