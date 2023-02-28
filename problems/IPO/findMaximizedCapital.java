class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int max = 0;
        for(int i : capital){
            max = Math.max(i,max);
        }

        if(w >= max){
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
            for (int p: profits) {
                pq.add(p);
                if (pq.size() > k)
                    pq.poll();
            }
            for (int it: pq)
                w += it;
            return w;
        }

        int index;
        int n = profits.length;
        for(int i = 0; i < Math.min(k, n); i++) {
            index = -1;
            for(int j = 0; j < n; ++j) {
                if (capital[j] <= w && (index == -1 || profits[index] < profits[j])){
                        index = j;
                }
            }
            if(index == -1) break;
            w += profits[index];
            capital[index] = Integer.MAX_VALUE;
        }
        return  w;
    }
}
