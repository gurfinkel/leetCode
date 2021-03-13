class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> store = new HashSet<>();

        for (int idx = 0; s.length() - k >= idx; ++idx) {
            store.add(s.substring(idx, idx + k));
        }

        return store.size() == Math.pow(2, k);
    }
}
