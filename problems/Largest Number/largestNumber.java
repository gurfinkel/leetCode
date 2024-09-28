class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[nums.length];

        for (int idx = 0; nums.length > idx; ++idx) {
            strings[idx] = Integer.toString(nums[idx]);
        }

        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));

        if ("0".equals(strings[0])) {
            return "0";
        }

        for (String item : strings) {
            sb.append(item);
        }

        return sb.toString();
    }
}
