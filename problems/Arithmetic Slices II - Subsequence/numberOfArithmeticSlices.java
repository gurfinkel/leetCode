class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        long result = 0;
        int n = nums.length;
        HashMap<Integer, Integer>[] cnt = new HashMap[n];

        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)nums[i] - (long)nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin + sum + 1);
                result += sum;
            }
        }
        return (int)result;
    }
}
