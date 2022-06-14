class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = website.length;
        String[][] logs = new String[n][3];
        HashMap<String, List<String>> userToPages = new HashMap<>();
        HashMap<String, Integer> store = new HashMap<>();
        String bestPattern = "";
        int maxCount = 0;

        for (int idx = 0; n > idx; ++idx) {
            logs[idx] = new String[] {username[idx],String.valueOf(timestamp[idx]),website[idx]};
        }

        Arrays.sort(logs, (l1,l2)->Integer.valueOf(l1[1])-Integer.valueOf(l2[1]));

        for (String[] log : logs) {
            if (!userToPages.containsKey(log[0])) {
                userToPages.put(log[0], new ArrayList<>());
            }
            userToPages.get(log[0]).add(log[2]);
        }

        for (String user : userToPages.keySet()) {
            HashSet<String> patterns = getAllPatterns(userToPages.get(user));

            for (String pattern : patterns) {
                int count = 1 + store.getOrDefault(pattern, 0);

                if (maxCount < count) {
                    maxCount = count;
                    bestPattern = pattern;
                } else if (maxCount == count) {
                    bestPattern = 0 > pattern.compareTo(bestPattern) ? pattern : bestPattern;
                }

                store.put(pattern, count);
            }
        }

        return Arrays.asList(bestPattern.split(","));
    }

    HashSet<String> getAllPatterns(List<String> pages) {
        int n = pages.size();
        HashSet<String> result = new HashSet<>();

        if (3 > n) {
            return result;
        }

        for (int i = 0; n - 2 > i; ++i) {
            for (int j = 1 + i; n - 1 > j; ++j) {
                for (int k = 1 + j; n > k; ++k) {
                    result.add(pages.get(i)+","+pages.get(j)+","+pages.get(k));
                }
            }
        }

        return result;
    }
}
