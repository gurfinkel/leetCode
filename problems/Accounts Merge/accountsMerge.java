class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Dsu dsu = new Dsu(10000);
        HashMap<Integer, List<String>> idToEmailsMap = new HashMap<>();
        HashMap<String, String> emailToNameMap = new HashMap<>();
        HashMap<String, Integer> emailToIdMap = new HashMap<>();
        int id = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int idx = 1; account.size() > idx; ++idx) {
                String email = account.get(idx);

                if (!emailToNameMap.containsKey(email)) {
                    emailToNameMap.put(email, name);
                }

                if (!emailToIdMap.containsKey(email)) {
                    emailToIdMap.put(email, id);
                    ++id;
                }

                dsu.union(emailToIdMap.get(account.get(1)), emailToIdMap.get(email));
            }
        }

        for (Map.Entry<String, Integer> emailAndId : emailToIdMap.entrySet()) {
            int parentId = dsu.find(emailAndId.getValue());

            if (!idToEmailsMap.containsKey(parentId)) {
                idToEmailsMap.put(parentId, new ArrayList<String>());
            }

            idToEmailsMap.get(parentId).add(emailAndId.getKey());
        }

        for (int parentId : idToEmailsMap.keySet()) {
            String name = emailToNameMap.get(idToEmailsMap.get(parentId).get(0));

            Collections.sort(idToEmailsMap.get(parentId));
            idToEmailsMap.get(parentId).add(0, name);
        }

        return new ArrayList(idToEmailsMap.values());
    }

    private class Dsu {
        int[] parents;
        int[] ranks;

        public Dsu(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int idx = 0; n > idx; ++idx) {
                parents[idx] = idx;
            }
        }

        public int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }

            return parents[a];
        }

        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            if (parentA != parentB) {
                if (ranks[parentA] > ranks[parentB]) {
                    parents[parentB] = parentA;
                    ++ranks[parentA];
                } else {
                    parents[parentA] = parentB;
                    ++ranks[parentB];
                }
            }
        }
    }
}
