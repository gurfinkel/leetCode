public class Solution {
    public int[] SortArrayByParity(int[] A) {
        Array.Sort(A, (a, b) => {
            if (1 == (a&1) && 0 == (b&1)) {
                return 1;
            } else if (0 == (a&1) && 1 == (b&1)) {
                return -1;
            } else {
                return 0;
            }
        });

        return A;
    }
}
