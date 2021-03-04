class Solution {
    public int findLHS(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int num: nums) {
            store.put(num, 1 + store.getOrDefault(num, 0));
        }

        for (int key: store.keySet()) {
            result = Math.max(result, store.get(key) + store.getOrDefault(1 + key, -store.get(key)));
        }

        return result;
    }
}
