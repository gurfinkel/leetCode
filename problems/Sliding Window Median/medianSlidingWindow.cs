public class Solution {
    public double[] MedianSlidingWindow(int[] nums, int k) {
        var result = new List<double>();

        if (k <= 0 || nums.Length == 0) return result.ToArray();

        var slidingWindow = new List<long>();

        for (int i = 0; i < nums.Length; i++) {
            var target = nums[i];

            var left = 0;
            var right = slidingWindow.Count;

            while (left < right) {
                var mid = left + (right - left) / 2;

                if (slidingWindow[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            slidingWindow.Insert(left, target);

            if (i >= k - 1) {
                if (i >= k) {
                    slidingWindow.Remove(nums[i - k]);
                }

                if (k % 2 == 1) result.Add(slidingWindow[k / 2]);
                else {
                    result.Add((slidingWindow[k / 2 - 1] + slidingWindow[k / 2]) / 2.0);
                }
            }
        }

        return result.ToArray();
    }
}
