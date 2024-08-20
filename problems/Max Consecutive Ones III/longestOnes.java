class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        int zeroCounter = 0;

        while (nums.length > rightIdx) {
            if (0 == nums[rightIdx]) {
                ++zeroCounter;
            }

            while (leftIdx <= rightIdx && k < zeroCounter) {
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
