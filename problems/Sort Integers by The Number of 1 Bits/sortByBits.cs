public class Solution {
    public int[] SortByBits(int[] arr) {
        Array.Sort(arr, (a, b) => compareNumbersInBinary(a, b));

        return arr;
    }

    private int compareNumbersInBinary(int a, int b) {
        int aNumberOfBits = getNumberOfBits(a);
        int bNumberOfBits = getNumberOfBits(b);

        if (aNumberOfBits == bNumberOfBits) {
            return a - b;
        } else {
            return aNumberOfBits - bNumberOfBits;
        }
    }

    private int getNumberOfBits(int n) {
        int result = 0;

        while (1 < n) {
            if (1 == (n & 1)) {
                ++result;
            }
            n >>= 1;
        }

        return result;
    }
}
