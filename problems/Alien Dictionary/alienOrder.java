class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjacencyStore = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<Character> bfs = new LinkedList<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjacencyStore.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; words.length - 1 > i; ++i) {
            String word1 = words[i];
            String word2 = words[1 + i];
            int len1 = word1.length();
            int len2 = word2.length();

            if (len1 > len2 && word1.startsWith(word2)) {
                return "";
            }

            int j = 0;
            while (Math.min(len1, len2) > j && word1.charAt(j) == word2.charAt(j)) {++j;}
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
            Character c = bfs.poll();

            sb.append(c);

            for (Character next : adjacencyStore.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (0 == counts.get(next)) {
                    bfs.add(next);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }

        return sb.toString();
    }
}
