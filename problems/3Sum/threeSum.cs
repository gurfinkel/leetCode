public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        var result = new List<IList<int>>();

        Array.Sort(nums);

        for (int pivot = 0; pivot < nums.Length; pivot++) {
            //No need to pivot on the same number as the one previously used.
            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) {
                continue;
            }

            //Since we have to find triplets whose sum is 0.
            var targetSum = -(nums[pivot]);

            var startIndex = pivot + 1;
            var endIndex = nums.Length - 1;
            while (startIndex < endIndex) {
                var sumOfValuesAtStartAndEndIndex = nums[startIndex] + nums[endIndex];
                if (sumOfValuesAtStartAndEndIndex == targetSum) {
                    result.Add(new int[] { nums[pivot], nums[startIndex], nums[endIndex] });

                    //No need to look at the same number if its already is in the result.
                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                        ++startIndex;
                    }

                    //No need to look at the same number if its already is in the result.
                    while (startIndex < endIndex && nums[endIndex] == nums[endIndex - 1]) {
                        --endIndex;
                    }

                    ++startIndex;
                    --endIndex;
                } else {
                    if (sumOfValuesAtStartAndEndIndex < targetSum)
                    {
                        //If sumOfValuesAtStartAndEndIndex is less than the targetSum,
                        //we need to increase the sumOfValuesAtStartAndEndIndex
                        //by taking the next big number.
                        ++startIndex;
                    } else {
                        //Else we need to decrease the sumOfValuesAtStartAndEndIndex,
                        //by taking the next smaller number.
                        --endIndex;
                    }
                }
            }
        }

        return result;
    }
}
