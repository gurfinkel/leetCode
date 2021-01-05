class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> store = new HashMap<> ();
        boolean flag = (0 == (s.length() & 1));

        for (char letter : s.toCharArray()) {
            store.put(letter, 1 + store.getOrDefault(letter, 0));
        }

        for (Map.Entry<Character, Integer> entry : store.entrySet()) {
            if (1 == (entry.getValue() & 1)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }

        return true;
    }
}
