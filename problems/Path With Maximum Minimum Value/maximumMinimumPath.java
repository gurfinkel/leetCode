class Solution {
    public int maximumMinimumPath(int[][] A) {
        int result = -1;
        int rows = A.length;
        int cols = A[0].length;
        int left = 0;
        int right = Math.min(A[0][0], A[rows - 1][cols - 1]);

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean isFound = dfs(A, 0, 0, mid, new boolean[rows][cols]);

            if (isFound) {
                result = mid;
                left = 1 + mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    boolean dfs(int[][] matrix, int row, int col, int minScore, boolean[][] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows - 1 == row && cols - 1 == col) {
            return true;
        }

        visited[row][col] = true;

        if (rows > 1 + row && !visited[1 + row][col] && matrix[1 + row][col] >= minScore) {
            if (dfs(matrix, 1 + row, col, minScore, visited)) {
                return true;
            }
        }

        if (cols > 1 + col && !visited[row][1 + col] && matrix[row][1 + col] >= minScore) {
            if (dfs(matrix, row, 1 + col, minScore, visited)) {
                return true;
            }
        }

        if (0 < row && !visited[row - 1][col] && matrix[row - 1][col] >= minScore) {
            if (dfs(matrix, row - 1, col, minScore, visited)) {
                return true;
            }
        }

        if (0 < col && !visited[row][col - 1] && matrix[row][col - 1] >= minScore) {
            if (dfs(matrix, row, col - 1, minScore, visited)) {
                return true;
            }
        }

        return false;
    }
}
