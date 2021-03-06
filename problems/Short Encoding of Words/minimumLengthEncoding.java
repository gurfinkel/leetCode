class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> store = new HashSet<>(Arrays.asList(words));
        int result = 0;

        for (String word: words) {
            for (int k = 1; word.length() > k; ++k) {
                store.remove(word.substring(k));
            }
        }

        for (String word: store) {
            result += 1 + word.length();
        }

        return result;
    }
}
