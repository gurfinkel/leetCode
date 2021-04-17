class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> bfs = new LinkedList<>();
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        int level = 0;

        if (dead.contains(start)) {
            return -1;
        }

        dead.add(start);
        bfs.add(start);

        while (!bfs.isEmpty()) {
            int count = bfs.size();

            for (int i = 0; count > i; ++i) {
                String current = bfs.poll();

                if (target.equals(current)) {
                    return level;
                }

                for (int j = 0; current.length() > j; ++j) {
                    String str1 = current.substring(0, j) + (1 + current.charAt(j) - '0') % 10 + current.substring(1 + j);
                    String str2 = current.substring(0, j) + (9 + current.charAt(j) - '0') % 10 + current.substring(1 + j);

                    if (!dead.contains(str1)) {
                        dead.add(str1);
                        bfs.add(str1);
                    }
                    if (!dead.contains(str2)) {
                        dead.add(str2);
                        bfs.add(str2);
                    }
                }
            }

            ++level;
        }

        return -1;
    }
}
