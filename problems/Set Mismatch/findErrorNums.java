class Solution {
    public int[] findErrorNums(int[] nums) {
        int rightSum = nums.length * (1 + nums.length) >> 1;
        int wrongSum = 0;
        HashSet<Integer> store = new HashSet<>();
        int extraNum = -1;

        for (int num : nums) {
            wrongSum += num;

            if (store.contains(num)) {
                extraNum = num;
            } else {
                store.add(num);
            }
        }

        return new int[] {extraNum, extraNum + rightSum - wrongSum};
    }
}
