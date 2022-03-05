class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> m = new HashMap();

        int ans = 0;
        for(int i=0; i<points.length;i++) {
            for(int j=0; j<points.length;j++) {
                if (i == j) continue;
                int dis = dist(points[i], points[j]);
                int prev = m.getOrDefault(dis,0);
                if (prev>=1) ans += prev*2;
                m.put(dis, prev+1);
            }
            m.clear();
        }


        return ans;

    }

    public int dist(int[] d1, int[] d2) {
        return (d1[0] - d2[0])*(d1[0] - d2[0]) + (d1[1] - d2[1])*(d1[1] - d2[1]);
    }
}
