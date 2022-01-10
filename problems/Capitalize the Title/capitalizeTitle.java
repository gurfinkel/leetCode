class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");

        for (int idx = 0; words.length > idx; ++idx) {
            if (1 == words[idx].length() || 2 == words[idx].length()) {
                words[idx] = words[idx].toLowerCase();
            } else {
                String firstLetter = words[idx].substring(0, 1).toUpperCase();
                String restLetters = words[idx].substring(1, words[idx].length()).toLowerCase();
                words[idx] = firstLetter + restLetters;
            }
        }

        return String.join(" ", words);
    }
}
