class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n - 2;

        while (0 <= left && nums[left] >= nums[1 + left]) {
            --left;
        }

        if (-1 != left) {
            int right = n - 1;

            while (0 <= right && nums[left] >= nums[right]) {
                --right;
            }

            swap(nums, left, right);
        }

        reverse(nums, 1 + left, n - 1);
    }

    private void reverse(int[] items, int i, int j) {
        while (i < j) {
            swap(items, i++, j--);
        }
    }

    private void swap(int[] items, int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
