class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        int left = 0;
        int right = 0;
        HashSet<Character> store = new HashSet<>();

        while (n > left) {
            while (store.contains(s.charAt(left))) {
                store.remove(s.charAt(right++));
            }
            store.add(s.charAt(left++));
            result = Math.max(result, store.size());
        }

        return result;
    }
}
