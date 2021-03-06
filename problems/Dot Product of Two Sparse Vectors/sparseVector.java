class SparseVector {
    public HashMap<Integer, Integer> store;

    SparseVector(int[] nums) {
        store = new HashMap<>();

        for (int idx = 0; nums.length > idx; ++idx) {
            if (0 != nums[idx]) {
                store.put(idx, nums[idx]);
            }
        }
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;

        for (int key : store.keySet()) {
            if (vec.store.containsKey(key)) {
                result += store.get(key) * vec.store.get(key);
            }
        }

        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
