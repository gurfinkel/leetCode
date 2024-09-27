class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumToCountMap = new HashMap<>();

        for (int num : nums) {
            sum += num;

            if (sum == goal) {
                ++result;
            }

            if (sumToCountMap.containsKey(sum - goal)) {
                result += sumToCountMap.get(sum - goal);
            }
            
            sumToCountMap.put(sum, 1 + sumToCountMap.getOrDefault(sum, 0));
        }

        return result;
    }
}
