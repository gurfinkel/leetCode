class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        HashMap<String, String> rawLetterToPlaceholderMap = new HashMap<>();
        HashMap<String, String> letterToPlaceholderMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (List<String> replacement : replacements) {
            rawLetterToPlaceholderMap.put(replacement.get(0), replacement.get(1));
        }

        for (String letter : rawLetterToPlaceholderMap.keySet()) {
            fillMapDfs(rawLetterToPlaceholderMap, letterToPlaceholderMap, letter);
        }

        while (text.length() > idx) {
            char symbol = text.charAt(idx);

            if ('%' == symbol && text.length() > 2 + idx && '%' == text.charAt(2 + idx)) {
                sb.append(letterToPlaceholderMap.get(Character.toString(text.charAt(1 + idx))));
                idx += 3;
            } else {
                sb.append(symbol);
                ++idx;
            }
        }

        return sb.toString();
    }

    private String fillMapDfs(HashMap<String, String> replacements, HashMap<String, String> result, String letter) {
        if (!result.containsKey(letter)) {
            StringBuilder sb = new StringBuilder();
            String template = replacements.get(letter);
            int idx = 0;

            while (template.length() > idx) {
                char symbol = template.charAt(idx);
                if ('%' == symbol && template.length() > 2 + idx && '%' == template.charAt(2 + idx)) {
                    sb.append(fillMapDfs(replacements, result, Character.toString(template.charAt(1 + idx))));
                    idx += 3;
                } else {
                    sb.append(symbol);
                    ++idx;
                }
            }

            result.put(letter, sb.toString());
        }

        return result.get(letter);
    }
}
