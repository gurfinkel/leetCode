class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
          
        return Math.min(nums[0], nums[pivot]);
    }

    int findPivot(int[] nums) {
        // the initial value for left index is 0
        int left = 0;
        // the initial value for right index is the number of elements in the array
        int right = nums.length;
        // left + 1 >= right will finish while loop
        while (left + 1 < right) {
            int mid = (right + left) / 2;

            if (nums[mid - 1] > nums[mid]) {
                // mid is the index to answer
                return mid;
            } else if (nums[left] < nums[mid]) {
                // there is no sense to search in the left half of the array
                left = mid;
            } else {
                // there is no sense to search in the right half of the array
                right = mid;
            }
        }
        // left is the answer
        return left;
    }
}
