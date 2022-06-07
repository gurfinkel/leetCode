class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        HashMap<Character, Integer> letterFrequencies = new HashMap<>();

        for (char symbol : magazine.toCharArray()) {
            letterFrequencies.put(symbol, 1 + letterFrequencies.getOrDefault(symbol, 0));
        }

        for (char symbol : ransomNote.toCharArray()) {
            if (0 == letterFrequencies.getOrDefault(symbol, 0)) {
                return false;
            } else {
                letterFrequencies.put(symbol, letterFrequencies.get(symbol) - 1);
            }
        }

        return true;
    }
}
