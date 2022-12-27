class Solution {
    public int calculateTime(String keyboard, String word) {
        int result = 0;
        HashMap<Character, Integer> store = new HashMap<>();
        int prevIdx = 0;

        for (int idx = 0; keyboard.length() > idx; ++idx) {
            store.put(keyboard.charAt(idx), idx);
        }

        for (char letter : word.toCharArray()) {
            result += Math.abs(prevIdx - store.get(letter));
            prevIdx = store.get(letter);
        }

        return result;
    }
}
