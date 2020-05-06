class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (0 == count) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }

        return candidate;
    }
}
