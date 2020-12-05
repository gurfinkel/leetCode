class Solution {
    public int search(int[] nums, int target) {
        // return binarySearchBasic(nums, target);
        // return binarySearchAdvanced(nums, target);
        return binarySearchWithNeighbors(nums, target);
    }

    int binarySearchBasic(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;

        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }

    int binarySearchAdvanced(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;

        return -1;
    }

    int binarySearchWithNeighbors(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;

        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;

        return -1;
    }
}
