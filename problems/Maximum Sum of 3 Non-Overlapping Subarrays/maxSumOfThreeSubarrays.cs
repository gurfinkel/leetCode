public class Solution {
    public int[] MaxSumOfThreeSubarrays(int[] nums, int k) {
        long sum = 0;
        long[] sums = new long[nums.Length];

        for (int i = 0; i < nums.Length; i++)
        {
            sum += nums[i];
            sums[i] = sum;
        }

        (long sum, int[] indices)[,] dp = new (long sum, int[] indices)[nums.Length, 3];


        dp[k - 1, 0] = (sums[k - 1], new []{0});

        for (int i = k; i < nums.Length; i++)
        {
            long subArrSum = sums[i] - sums[i - k];
            int subArrKey = (i - k + 1);

            dp[i, 0] = dp[i - 1, 0];

            if (subArrSum > dp[i, 0].sum)
            {
                dp[i, 0] = (subArrSum, new []{subArrKey});
            }
        }

        for (int i = k; i < nums.Length; i++)
        {
            int left = i - k;

            for (int j = 1; j < 3; j++)
            {
                if (left < 0)
                {
                    continue;
                }

                long subArrSum = sums[i] - sums[left];
                dp[i, j] = dp[i - 1, j];
                int newKey = left + 1;

                if (dp[left, j - 1].indices != null)
                {
                    long newSum = dp[left, j - 1].sum + subArrSum;

                    if (dp[i, j].indices == null|| newSum > dp[i, j].sum)
                    {
                        var tmp = dp[left, j - 1].indices.ToList();
                        tmp.Add(newKey);
                        dp[i, j] = (newSum, tmp.ToArray());
                    }

                }
            }
        }

        long max = long.MinValue;
        int[] res = null;

        for (int i = 0; i < nums.Length; i++)
        {
            if (dp[i, 2].indices != null)
            {
                if (dp[i, 2].sum > max)
                {
                    max = dp[i, 2].sum;
                    res = dp[i, 2].indices;
                }
            }
        }

        return res;
    }
}
