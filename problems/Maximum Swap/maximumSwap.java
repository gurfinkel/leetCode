class Solution {
    public int maximumSwap(int num) {
        int result = 0;
        List<Integer> digits = new ArrayList<>();
        int maxDigitIdx = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        
        // 3276 -> [6,7,2,3]
        while (0 < num) {
            digits.add(num %10);
            num /= 10;
        }
        
        for (int idx = 1; digits.size() > idx; ++idx) {
            if (digits.get(maxDigitIdx) < digits.get(idx)) {
                maxDigitIdx = idx;
            } else if (digits.get(maxDigitIdx) > digits.get(idx)) {
                rightIdx = maxDigitIdx;
                leftIdx = idx;
            }
        }
        // maxDigitIdx = 1; leftIdx = 3; rightIdx = 1;
        swap(digits, leftIdx, rightIdx);
        // [6,3,2,7]
        for (int idx = digits.size() - 1; 0 <= idx; --idx) {
            result = 10 * result + digits.get(idx);
        }
        // 7236
        return result;
    }

    private void swap(List<Integer> items, int i, int j) {
        int tmp = items.get(i);
        items.set(i, items.get(j));
        items.set(j, tmp);
    }
}
