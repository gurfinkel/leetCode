class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (k >= grid.length + grid[0].length-2) {
            return grid.length + grid[0].length-2;
        }

        int[][] visit = new int[grid.length][grid[0].length];

        for (int[] v : visit) {
            Arrays.fill(v, -1);
        }

        int[] dirs = new int[]{0,1,0,-1,0};
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0,0,k,0});
        visit[0][0] = k;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == grid.length-1 && curr[1] == grid[0].length-1) {
                return curr[3];
            }
            for(int j = 1; j < dirs.length; j++) {
                int nr = curr[0] + dirs[j-1];
                int nc = curr[1] + dirs[j];
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                    continue;
                }
                int nk = curr[2];
                if(grid[nr][nc] == 1) {
                    nk--;
                }
                if(nk < 0 || visit[nr][nc] >= nk) {
                    continue;
                }
                visit[nr][nc] = nk;
                q.add(new int[]{nr,nc,nk,curr[3]+1});
            }

        }
        return -1;
    }
}
