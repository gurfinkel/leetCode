class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return (int)dfs(startRow,startColumn,maxMove,m,n,new Long[1 + maxMove][m][n]);
    }

    public long dfs(int i,int j,int maxMove,int m,int n,Long[][][] dp){
        if ((0 > i || m == i || 0 > j || n == j) && 0 <= maxMove) {
            return 1L;
        } else if (0 == maxMove) {
            return 0L;
        } else if (null == dp[maxMove][i][j]) {
            dp[maxMove][i][j] = (dfs(i - 1, j, maxMove - 1, m, n, dp) +
                dfs(1 + i, j, maxMove - 1, m, n, dp) +
                dfs(i, j - 1, maxMove - 1, m, n, dp) +
                dfs(i, 1 + j, maxMove - 1, m, n, dp))%1000000007;
        }

        return dp[maxMove][i][j];
    }
}
