class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int num = 1;
        int max = Integer.MIN_VALUE;
        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        for (int i = 0; n > i; ++i) {
            maxArr[i] = nums[i];
            minArr[i] = nums[i];

            if (0 < i) {
                maxArr[i] = Math.max(maxArr[i], nums[i] * maxArr[i - 1]);
                maxArr[i] = Math.max(maxArr[i], nums[i] * minArr[i - 1]);

                minArr[i] = Math.min(minArr[i], nums[i] * maxArr[i - 1]);
                minArr[i] = Math.min(minArr[i], nums[i] * minArr[i - 1]);
            }

            if (maxArr[i] > max) {
                max = maxArr[i];
            }
        }

        return max;
    }
}
