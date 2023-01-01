class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> store = new HashSet<>();
        int item = 2;

        for (int num : nums) {
            int n = num;

            item = 2;

            while (2 <= n) {
                if (0 == n % item) {
                    store.add(item);
                    n /= item;
                } else {
                    ++item;
                }
            }
        }

        return store.size();
    }
}
