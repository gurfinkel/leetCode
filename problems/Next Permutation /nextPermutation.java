class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n - 2;
        // [3,5,4,2,1] -> [4,1,2,3,5]
        while (0 <= left && nums[left] >= nums[1 + left]) {
            --left;
        }
        // left: 0
        if (-1 != left) {
            int right = n - 1;

            while (0 <= right && nums[left] >= nums[right]) {
                --right;
            }
            // right: 2
            swap(nums, left, right);
            // [4,5,3,2,1]
        }

        reverse(nums, 1 + left, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }
}
