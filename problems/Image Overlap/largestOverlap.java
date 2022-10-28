class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int result = 0;

        for (int i = 0; i < n; i++) { //row shift
            for (int j = 0; j < n; j++) {  //col shift
                result = Math.max(result, count(img1, img2, n, i, j));
                result = Math.max(result, count(img2, img1, n, i, j));
            }
        }

        return result;
    }
    int count(int[][] img1, int[][] img2, int n, int r, int c) {
        int over1 = 0;
        int over2 = 0;

        for (int i = r; i < n; i++) {
            for (int j = c; j < n; j++) {
                over1 += img1[i-r][j-c] & img2[i][j]; //right
                over2 += img1[i-r][j] & img2[i][j-c]; //left
            }
        }

        return Math.max(over1, over2);
    }
}
