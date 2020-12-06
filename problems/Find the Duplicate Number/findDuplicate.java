class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        return singleDuplicate(nums);
    }

    private int singleDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left + 1 < right) {
            int mid = (right + left) / 2;

            if (nums[mid] == nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
