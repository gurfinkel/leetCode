class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> adjacencyStore = new HashMap<>();
        HashMap<Character, Integer> counts = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<Character> bfs = new LinkedList<>();

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                counts.put(letter, 0);
                adjacencyStore.put(letter, new ArrayList<>());
            }
        }

        for (int i = 0; words.length - 1 > i; ++i) {
            String word1 = words[i];
            String word2 = words[1 + i];
            int len1 = word1.length();
            int len2 = word2.length();
            int j = 0;

            if (len1 > len2 && word1.startsWith(word2)) {
                return "";
            }

            while (Math.min(len1, len2) > j && word1.charAt(j) == word2.charAt(j)) {
                ++j;
            }

            if (Math.min(len1, len2) > j) {
                adjacencyStore.get(word1.charAt(j)).add(word2.charAt(j));
                counts.put(word2.charAt(j), 1 + counts.get(word2.charAt(j)));
            }
        }

        for (Character c : counts.keySet()) {
            if (0 == counts.get(c)) {
                bfs.add(c);
            }
        }

        while (!bfs.isEmpty()) {
            Character letter = bfs.poll();

            sb.append(letter);

            for (Character nextLetter : adjacencyStore.get(letter)) {
                counts.put(nextLetter, counts.get(nextLetter) - 1);

                if (0 == counts.get(nextLetter)) {
                    bfs.add(nextLetter);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }

        return sb.toString();
    }
}
