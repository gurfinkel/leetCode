class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> store = new HashSet<Integer>();

        for (int num : nums) {
            store.add(num);

            if (3 < store.size()) {
                store.remove(Collections.min(store));
            }
        }

        if (3 == store.size()) {
            return Collections.min(store);
        }

        return Collections.max(store);
    }
}
