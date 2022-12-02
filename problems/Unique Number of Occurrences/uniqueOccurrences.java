class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> store = new HashMap<>();
        HashSet<Integer> uniqueFrequencies = new HashSet<>();

        for (int item : arr) {
            store.put(item, 1 + store.getOrDefault(item, 0));
        }

        for (int key : store.keySet()) {
            if (uniqueFrequencies.contains(store.get(key))) {
                return false;
            }
            uniqueFrequencies.add(store.get(key));
        }

        return true;
    }
}
