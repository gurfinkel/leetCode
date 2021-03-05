class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> store = new HashMap<>();
        int idx = 0;

        for (char letter : order.toCharArray()) {
            store.put(letter, idx++);
        }

        for (idx = 1; words.length > idx; ++idx) {
            if (0 < compare(store, words[idx - 1], words[idx])) {
                return false;
            }
        }

        return true;
    }

    private int compare(HashMap<Character, Integer> dict, String a, String b) {
        if (a.equals(b)) {
            return 0;
        }

        int idx = 0;

        while (a.length() > idx && b.length() > idx) {
            if (dict.get(a.charAt(idx)) == dict.get(b.charAt(idx))) {
                ++idx;
            } else {
                return dict.get(a.charAt(idx)) - dict.get(b.charAt(idx));
            }
        }

        return a.length() - b.length();
    }
}
