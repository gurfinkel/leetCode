class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<Integer, List<String>> result = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, Integer> emailToId = new HashMap<>();
        Dsu dsu = new Dsu(10000);
        int id = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int idx = 1; account.size() > idx; ++idx) {
                String email = account.get(idx);

                if (!emailToName.containsKey(email)) {
                    emailToName.put(email, name);
                }

                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }

                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        for (String email : emailToName.keySet()) {
            int idx = dsu.find(emailToId.get(email));

            if (!result.containsKey(idx)) {
                result.put(idx, new ArrayList<String>());
            }

            result.get(idx).add(email);
        }

        for (int idx : result.keySet()) {
            Collections.sort(result.get(idx));
            result.get(idx).add(0, emailToName.get(result.get(idx).get(0)));
        }

        return new ArrayList(result.values());
    }

    class Dsu {
        int[] parents;
        int[] ranks;

        Dsu(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                parents[idx] = idx;
            }
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px != py) {
                if (ranks[px] > ranks[py]) {
                    parents[py] = px;
                    ++ranks[px];
                } else {
                    parents[px] = py;
                    ++ranks[py];
                }
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }

            return parents[x];
        }
    }
}
