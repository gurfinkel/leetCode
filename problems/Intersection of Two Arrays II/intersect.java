class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> store = new HashMap<>();
        int size = 0;

        for (int item : nums1) {
            store.put(item, 1 + store.getOrDefault(item, 0));
        }

        for (int item : nums2) {
            if (store.containsKey(item)) {
                if (0 < store.get(item)) {
                    nums1[size++] = item;
                    store.put(item, store.get(item) - 1);
                }
            }
        }

        return Arrays.copyOfRange(nums1, 0, size);
    }
}
