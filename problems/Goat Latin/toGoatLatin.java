class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; words.length > idx; ++idx) {
            String newWord = modifyWord(words[idx], idx);

            if (0 != newWord.length()) {
                if (0 != idx) {
                    sb.append(" ");
                }

                sb.append(newWord);
            }
        }

        return sb.toString();
    }

    private String modifyWord(String word, int idx) {
        String result = word;

        if (null == word || 0 == word.length()) {
            return "";
        }

        if ('a' != word.charAt(0) && 'e' != word.charAt(0) && 'i' != word.charAt(0) && 'o' != word.charAt(0) && 'u' != word.charAt(0) &&
            'A' != word.charAt(0) && 'E' != word.charAt(0) && 'I' != word.charAt(0) && 'O' != word.charAt(0) && 'U' != word.charAt(0)) {
            result = word.substring(1) + word.substring(0, 1);
        }

        result += "ma";

        while (0 <= idx) {
            result += "a";
            --idx;
        }

        return result;
    }
}
