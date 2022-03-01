class Solution {
    public int[] findPeakGrid(int[][] mat) {
        return findPeakGridBs(mat);
        // return findPeakGridBfs(mat);
    }

    public int[] findPeakGridBs(int[][] mat) {
        int rows = mat.length;
        int left = 0;
        int right = rows;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int col = getMaxIdx(mat[mid]);
            boolean up = 0 >= mid || mat[mid - 1][col] < mat[mid][col];
            boolean down = rows <= 1 + mid || mat[1 + mid][col] < mat[mid][col];

            if (up && down) {
                return new int[]{mid,col};
            } else if (0 < mid && mat[mid - 1][col] < mat[mid][col]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return new int[]{left,getMaxIdx(mat[left])};
    }

    int getMaxIdx(int[] nums) {
        int maxIdx = 0;

        for (int idx = 1; nums.length > idx; ++idx) {
            if (nums[idx] > nums[maxIdx]) {
                maxIdx = idx;
            }

        }

        return maxIdx;
    }

    public int[] findPeakGridBfs(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> bfs = new LinkedList<>();

        bfs.add(new int[] {0,0});

        while (!bfs.isEmpty()) {
            int[] items = bfs.poll();
            int row = items[0];
            int col = items[1];

            int nextRowVal = rows > 1 + row ? mat[1 + row][col] : 0;
            int nextColVal = cols > 1 + col ? mat[row][1 + col] : 0;
            int prevRowVal = 0 < row ? mat[row - 1][col] : 0;
            int prevColVal = 0 < col ? mat[row][col - 1] : 0;

            int maxVal = Math.max(Math.max(Math.max(nextRowVal, nextColVal), Math.max(prevRowVal, prevColVal)), mat[row][col]);

            if (mat[row][col] == maxVal) {
                return new int[] {row, col};
            }

            if (nextRowVal == maxVal) {
                bfs.add(new int[] {1 + row, col});
            } else if (nextColVal == maxVal) {
                bfs.add(new int[] {row, 1 + col});
            } else if (prevRowVal == maxVal) {
                bfs.add(new int[] {row - 1, col});
            } else if (prevColVal == maxVal) {
                bfs.add(new int[] {row, col - 1});
            }
        }

        return null;
    }
}
