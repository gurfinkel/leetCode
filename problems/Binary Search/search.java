class Solution {
    public int search(int[] nums, int target) {
        // return searchInBst(nums, target);
        // return binarySearchBasic(nums, target);
        // return binarySearchAdvanced(nums, target);
        return binarySearchWithNeighbors(nums, target);
    }

    private int searchInBst(int[] nums, int target) {
        TreeMap<Integer, Integer> bst = new TreeMap<Integer, Integer>();

        for (int idx = 0; nums.length > idx; ++idx) {
            bst.put(nums[idx], idx);
        }

        return bst.containsKey(target) ? bst.get(target) : -1;
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
