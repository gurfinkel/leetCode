class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, Integer> patternFrequencies = new HashMap<>();
        HashMap<String, List<String>> userToPages = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        int maxFrequency = 0;
        String bestPattern = "";

        for (int idx = 0; username.length > idx; ++idx) {
            logs.add(new String[] {username[idx],String.valueOf(timestamp[idx]),website[idx]});
        }

        Collections.sort(logs, (l1, l2) -> Integer.valueOf(l1[1]) - Integer.valueOf(l2[1]));

        for (String[] log : logs) {
            if (!userToPages.containsKey(log[0])) {
                userToPages.put(log[0], new ArrayList<>());
            }
            userToPages.get(log[0]).add(log[2]);
        }

        for (String user : userToPages.keySet()) {
            if (3 > userToPages.get(user).size()) {
                continue;
            }

            HashSet<String> patterns = getAllPatterns(userToPages.get(user));

            for (String pattern : patterns) {
                int frequency = 1 + patternFrequencies.getOrDefault(pattern, 0);

                patternFrequencies.put(pattern, frequency);

                if (frequency > maxFrequency) {
                    bestPattern = pattern;
                    maxFrequency = frequency;
                } else if (frequency == maxFrequency) {
                    bestPattern = 0 > pattern.compareTo(bestPattern) ? pattern : bestPattern;
                }
            }
        }

        return Arrays.asList(bestPattern.split(","));
    }

    private HashSet<String> getAllPatterns(List<String> list) {
        HashSet<String> result = new HashSet<>();
        int n = list.size();

        for (int i = 0; n - 2 > i; ++i) {
            for (int j = 1 + i; n - 1 > j; ++j) {
                for (int k = 1 + j; n > k; ++k) {
                    result.add(list.get(i)+','+list.get(j)+','+list.get(k));
                }
            }
        }

        return result;
    }
}
