class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> store = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[\\p{Punct}\\s]+");
        int frequency = 0;
        String result = "";

        for (String word : words) {
            if (0 == word.trim().length()) {
                continue;
            }

            String lowCaseWord = word.toLowerCase();

            if (!store.contains(lowCaseWord)) {
                if (map.containsKey(lowCaseWord)) {
                    map.put(lowCaseWord, 1 + map.get(lowCaseWord));
                } else {
                    map.put(lowCaseWord, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> word : map.entrySet()) {
            if (word.getValue() > frequency) {
                frequency = word.getValue();
                result = word.getKey();
            }
        }

        return result;
    }
}
