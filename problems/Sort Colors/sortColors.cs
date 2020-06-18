public class Solution {
    public void SortColors(int[] nums) {
        int zeroIdx = 0;
        int currIdx = 0;
        int twoIdx = nums.Length - 1;

        while (currIdx <= twoIdx) {
            if (0 == nums[currIdx]) {
                swap(nums, zeroIdx++, currIdx++);
            } else if (2 == nums[currIdx]) {
                swap(nums, currIdx, twoIdx--);
            } else {
                ++currIdx;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
