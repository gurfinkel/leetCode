class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        Arrays.sort(matchsticks);

        for (int matchstick : matchsticks) {
            sum += matchstick;
        }

        for (int i = 0, j = matchsticks.length - 1; i < j; ++i, --j) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int target = (sum >> 2);

        if (4 > matchsticks.length || 0 != sum % 4 || matchsticks[0] > target) {
            return false;
        }

        return dfs(matchsticks, target, 0,0,0,new boolean[matchsticks.length]);
    }

    public boolean dfs(int[] nums,int target,int curSum,int start,int count, boolean[] used) {
        if (3 == count) {
            return true;
        }

        if (curSum == target) {
            return dfs(nums, target, 0, 0, 1 + count, used);
        }

        for (int i = start; nums.length > i; ++i) {
            if (used[i] || i>0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (curSum + nums[i] > target) {
                continue;
            }

            used[i] = true;

            if (dfs(nums, target, curSum + nums[i], 1 + i, count, used)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}
