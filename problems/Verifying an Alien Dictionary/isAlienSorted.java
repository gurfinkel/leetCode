class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> store = new HashMap<>();

        for (int idx = 0; order.length() > idx; ++idx) {
            store.put(order.charAt(idx), idx);
        }

        for (int idx = 1; words.length > idx; ++idx) {
            if (0 > compare(words[idx - 1], words[idx], store)) {
                return false;
            }
        }

        return true;
    }

    private int compare(String a, String b, HashMap<Character, Integer> dict) {
        if (a.equals(b)) {
            return 0;
        }

        int idx = 0;

        while (a.length() > idx && b.length() > idx) {
            if (dict.get(a.charAt(idx)) == dict.get(b.charAt(idx))) {
                ++idx;
            } else {
                return dict.get(b.charAt(idx)) - dict.get(a.charAt(idx));
            }
        }

        return b.length() - a.length();
    }
}
