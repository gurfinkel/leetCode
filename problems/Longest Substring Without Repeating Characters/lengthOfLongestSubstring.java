class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        int n = s.length();
        HashSet<Character> store = new HashSet<>();

        while (n > rightIdx) {
            if (store.contains(s.charAt(rightIdx))) {
                store.remove(s.charAt(leftIdx++));
            } else {
                store.add(s.charAt(rightIdx++));
                result = Math.max(result, rightIdx - leftIdx);
            }
        }

        return result;
    }
}