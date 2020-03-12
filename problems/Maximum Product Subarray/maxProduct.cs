public class Solution {
    public int MaxProduct(int[] nums) {
        int num = 1, max = int.MinValue;

        int[] maxArr = new int[nums.Length], minArr = new int[nums.Length];

        for (int i = 0; i < nums.Length; i++)
        {
            maxArr[i] = nums[i];
            minArr[i] = nums[i];

            if (i > 0)
            {
                maxArr[i] = Math.Max(maxArr[i], nums[i] * maxArr[i - 1]);
                maxArr[i] = Math.Max(maxArr[i], nums[i] * minArr[i - 1]);

                minArr[i] = Math.Min(minArr[i], nums[i] * maxArr[i - 1]);
                minArr[i] = Math.Min(minArr[i], nums[i] * minArr[i - 1]);

            }

            if (maxArr[i] > max)
                max = maxArr[i];
        }

        return max;
    }
}
