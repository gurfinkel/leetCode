class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        //find start point and total number of keys
        int result = 0;
        int m = grid.length;
        int n = grid[0].length();

        int k = 0;
        int x = 0, y = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch = grid[i].charAt(j);
                if(Character.isLowerCase(ch)) k |= (1<<(ch-'a'));
                if(grid[i].charAt(j)=='@'){
                    x = i;
                    y = j;
                }
            }
        }

        //BFS to find the shortest path
        boolean[][][] seen = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});


        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                for(int[] dir:dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    int nk = curr[2];
                    if(nr<0||
                       nr>=m||
                       nc<0||
                       nc>=n||
                       seen[nr][nc][nk]||
                       grid[nr].charAt(nc)=='#') continue;

                    char ch = grid[nr].charAt(nc);

                    if(Character.isLowerCase(ch)){
                        nk|=(1<<(ch-'a'));
                        if(nk==k) return result;
                    }

                    if(Character.isUpperCase(ch)){
                        if((nk&(1<<(ch-'a')))==0) continue;
                    }

                    seen[nr][nc][nk] = true;
                    queue.add(new int[]{nr,nc,nk});
                }

            }
        }
        return -1;
    }
}
