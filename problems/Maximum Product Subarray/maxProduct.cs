public class Solution {
    public int MaxProduct(int[] nums) {
        int n = nums.Length;
        int num = 1;
        int max = int.MinValue;
        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        for (int i = 0; n > i; ++i) {
            maxArr[i] = nums[i];
            minArr[i] = nums[i];

            if (0 < i) {
                maxArr[i] = Math.Max(maxArr[i], nums[i] * maxArr[i - 1]);
                maxArr[i] = Math.Max(maxArr[i], nums[i] * minArr[i - 1]);

                minArr[i] = Math.Min(minArr[i], nums[i] * maxArr[i - 1]);
                minArr[i] = Math.Min(minArr[i], nums[i] * minArr[i - 1]);
            }

            if (maxArr[i] > max) {
                max = maxArr[i];
            }
        }

        return max;
    }
}
