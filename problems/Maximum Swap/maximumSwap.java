class Solution {
    public int maximumSwap(int num) {
        int result = 0;
        List<Integer> digits = new ArrayList<>();
        int maxIdx = 0;
        int x = 0;
        int y = 0;

        while (0 < num) {
            digits.add(num % 10);
            num /= 10;
        }

        for (int idx = 1; digits.size() > idx; ++idx) {
            if (digits.get(idx) > digits.get(maxIdx)) {
                maxIdx = idx;
            } else if (digits.get(idx) < digits.get(maxIdx)) {
                x = maxIdx;
                y = idx;
            }
        }

        swap(digits, x, y);

        int idx = digits.size() - 1;

        while (0 <= idx) {
            result *= 10;
            result += digits.get(idx--);
        }

        return result;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
}
