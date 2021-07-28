class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> letterFrequencies = new HashMap<Character, Integer>();

        for (char letter : s.toCharArray()) {
            letterFrequencies.put(letter, 1 + letterFrequencies.getOrDefault(letter, 0));
        }

        for (int idx = 0; s.length() > idx; ++idx) {
            char letter = s.charAt(idx);

            if (1 == letterFrequencies.get(letter)) {
                return idx;
            }
        }

        return -1;
    }
}
