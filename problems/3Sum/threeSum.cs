public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        var result = new List<IList<int>>();

        Array.Sort(nums);

        for (int pivot = 0; pivot < nums.Length; pivot++) {
            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) {
                continue;
            }

            var targetSum = -(nums[pivot]);
            var startIndex = pivot + 1;
            var endIndex = nums.Length - 1;

            while (startIndex < endIndex) {
                var sumOfValuesAtStartAndEndIndex = nums[startIndex] + nums[endIndex];
                if (sumOfValuesAtStartAndEndIndex == targetSum) {
                    result.Add(new int[] { nums[pivot], nums[startIndex], nums[endIndex] });

                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                        ++startIndex;
                    }

                    while (startIndex < endIndex && nums[endIndex] == nums[endIndex - 1]) {
                        --endIndex;
                    }

                    ++startIndex;
                    --endIndex;
                } else {
                    if (sumOfValuesAtStartAndEndIndex < targetSum)
                    {
                        ++startIndex;
                    } else {
                        --endIndex;
                    }
                }
            }
        }

        return result;
    }
}
