class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> store = new HashMap<>();

        for (List<String> path : paths) {
            store.put(path.get(0), 1 + store.getOrDefault(path.get(0), 0));

            if (!store.containsKey(path.get(1))) {
                store.put(path.get(1), 0);
            }
        }

        for (String key : store.keySet()) {
            if (0 == store.get(key)) {
                return key;
            }
        }

        return null;
    }
}
