class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> store = new LinkedList<>();

        backtrack(n, k, store, 0, result);

        return result;
    }

    private void backtrack(int remain, int k, LinkedList<Integer> store, int i, List<List<Integer>> result) {

        if (0 == remain && k == store.size()) {
            result.add(new ArrayList<Integer>(store));
            return;
        } else if (0 > remain || k == store.size()) {
            return;
        }

        for (int idx = i; 9 > idx; ++idx) {
            store.add(1 + idx);
            backtrack(remain - idx - 1, k, store, 1 + idx, result);
            store.removeLast();
        }
    }
}
