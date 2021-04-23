class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        HashMap<String, List<String>> store = new HashMap<>();
        HashMap<String, HashSet<String>> parentChildMap = new HashMap<>();
        Queue<String> bfs = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        boolean found = false;
        int level = 0;

        for (String word : wordList) {
            for (int idx = 0; word.length() > idx; ++idx) {
                String newWord = word.substring(0, idx) + "*" + word.substring(1 + idx);
                List<String> list = store.getOrDefault(newWord , new ArrayList<>());

                list.add(word);
                store.put(newWord, list);
            }
        }

        bfs.add(beginWord);
        visited.add(beginWord);

        while (!bfs.isEmpty() && !found) {
            int size = bfs.size();

            for (int i = 0; size > i; ++i) {
                String curr = bfs.poll();
                visited.add(curr);

                if (curr.equals(endWord)) {
                    found = true;
                    break;
                }

                for (int j = 0; curr.length() > j; ++j) {
                    String newWord = curr.substring(0, j) + "*" + curr.substring(1 + j);
                    if (store.containsKey(newWord)) {
                        for (String word : store.get(newWord)) {
                            if (!visited.contains(word)) {
                                HashSet<String> list = parentChildMap.getOrDefault(word, new HashSet<>());
                                list.add(curr);
                                parentChildMap.put(word, list);
                                bfs.add(word);
                            }
                        }
                    }
                }
            }

            ++level;
        }

        buildOutput(beginWord, endWord, result, new LinkedList<>(), parentChildMap, level);

        return result;
    }

    public void buildOutput(String beginWord, String endWord, List<List<String>> result, List<String> curr, HashMap<String, HashSet<String>> parent, int level) {
        if (0 == level) {
            return;
        }

        if (beginWord.equals(endWord)) {
            List<String> list = new ArrayList<>(curr);

            list.add(0, endWord);
            result.add(list);

            return;
        }

        curr.add(0 , endWord);

        if (parent.get(endWord) != null) {
            for (String temp : parent.get(endWord)) {
                buildOutput(beginWord, temp, result, curr, parent , level - 1);
            }
        }

        curr.remove(0);
    }
}
