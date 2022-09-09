class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (1 == n) {
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }

        List<Integer> store = new ArrayList<>();

        for (int num = 1; num < 10; ++num) {
            dfs(n - 1, num, k, store);
        }

        // convert the ArrayList to int[]
        // return store.stream().mapToInt(i->i).toArray();
        int[] result = new int[store.size()];

        for (int idx = 0; store.size() > idx; ++idx) {
            result[idx] = store.get(idx);
        }

        return result;
    }

    protected void dfs(int n, int num, int k, List<Integer> result) {
        if (0 == n) {
            result.add(num);
            return;
        }

        List<Integer> nextDigits = new ArrayList<>();
        int tailDigit = num % 10;

        nextDigits.add(tailDigit + k);

        if (0 != k) {
            nextDigits.add(tailDigit - k);
        }

        for (int nextDigit : nextDigits) {
            if (0 <= nextDigit && 10  > nextDigit) {
                int newNum = 10 * num + nextDigit;
                dfs(n - 1, newNum, k, result);
            }
        }
    }
}
