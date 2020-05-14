class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int pivot = 0; nums.length > pivot; ++pivot) {
            if (0 < pivot && nums[pivot - 1] == nums[pivot]) {
                continue;
            }

            int startIdx = 1 + pivot;
            int endIdx = nums.length - 1;

            while (startIdx < endIdx) {
                if (0 == nums[pivot] + nums[startIdx] + nums[endIdx]) {
                    List<Integer> item = new ArrayList<Integer>();

                    item.add(nums[pivot]);
                    item.add(nums[startIdx]);
                    item.add(nums[endIdx]);
                    result.add(item);

                    while (startIdx < endIdx && nums[startIdx] == nums[1 + startIdx]) {
                        ++startIdx;
                    }

                    while (startIdx < endIdx && nums[endIdx - 1] == nums[endIdx]) {
                        --endIdx;
                    }

                    ++startIdx;
                    --endIdx;
                } else if (0 < nums[pivot] + nums[startIdx] + nums[endIdx]) {
                    --endIdx;
                } else {
                    ++startIdx;
                }
            }
        }

        return result;
    }
}
