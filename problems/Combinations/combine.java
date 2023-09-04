class Solution {
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, ans);
        return ans;
    }

    private int n;
    private int k;

    public void backtrack(List<Integer> curr, int firstNum, List<List<Integer>> ans) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        int need = k - curr.size();
        int remain = n - firstNum + 1;
        int available = remain - need;

        for (int num = firstNum; num <= firstNum + available; num++) {
            curr.add(num);
            backtrack(curr, num + 1, ans);
            curr.remove(curr.size() - 1);
        }

        return;
    }
}
