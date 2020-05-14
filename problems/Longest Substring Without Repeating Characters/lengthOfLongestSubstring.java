class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int result = 0;

        while (s.length() > right) {
            if (map.contains(s.charAt(right))) {
                map.remove(s.charAt(left++));
            } else {
                map.add(s.charAt(right++));
                result = Math.max(result, right - left);
            }
        }

        return result;
    }
}
