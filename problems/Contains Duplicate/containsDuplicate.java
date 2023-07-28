class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> store = new HashSet<>();

        for (int item : nums) {
            if (store.contains(item)) {
                return true;
            } else {
                store.add(item);
            }
        }

        return false;
    }
}
