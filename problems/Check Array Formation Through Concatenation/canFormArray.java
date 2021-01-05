class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i = -1;
        int j = 0;

        for (int item : arr) {
            if (-1 == i || pieces[i].length == j) {
                i = 0;
                j = 0;

                while (pieces.length > i && pieces[i][j] != item) {
                    ++i;
                }

                if (pieces.length == i) {
                    return false;
                } else if (1 == pieces[i].length) {
                    i = -1;
                } else {
                    ++j;
                }
            } else if (pieces[i][j++] != item) {
                return false;
            }
        }

        return true;
    }
}
