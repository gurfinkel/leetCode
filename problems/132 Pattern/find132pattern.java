class Solution {
    public boolean find132patternBruteForce(int[] nums) {
        int n = nums.length;
        int min_i = Integer.MAX_VALUE;

        for (int j = 0; n - 1 > j; ++j) {
            min_i = Math.min(min_i, nums[j]);

            for (int k = j + 1; n > k; ++k) {
                if (nums[k] < nums[j] && min_i < nums[k]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        if (3 > n) {
            return false;
        }

        Stack<Integer> stack = new Stack();
        int[] min = new int[n];

        min[0] = nums[0];

        for (int i = 1; n > i; ++i) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = n - 1; 0 <= j; --j) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }

                stack.push(nums[j]);
            }
        }

        return false;
    }
}
