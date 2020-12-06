class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        int[] priorities = new int[rains.length];
        //for each rained days we need to give priority so that when we find  the chance to dry we will dry the lake with the highest priority
        Map<Integer,Integer> rained=new HashMap<>();//to keep track the full lakes

        for (int i=0,p=1;i<rains.length;i++) {
            if (rains[i]!=0) {
                ans[i]=-1;
                if(rained.containsKey(rains[i]))//check if it is a full lake
                    priorities[rained.get(rains[i])]=p++;//give it priority
                rained.put(rains[i], i);
            }
        }
        PriorityQueue<Integer[]> priorityQueue=new PriorityQueue<>((x,y)->x[1]-y[1]);
        //the priority queue is an integer array with size two; the first idex represents the lake number
        //the second index represents the priority
        Set<Integer> pqSet=new HashSet<>();//to perform fast lookup on the priority queue
        for (int i=0;i<rains.length;i++) {
            if (rains[i]!=0&&pqSet.contains(rains[i]))return new int[]{};
            //we found a lake in the priority queue that is full; no solution is available
            if (rains[i]==0) {
                ans[i]=1;//in case we don't find a lake to dry; the default is 1
                if (!priorityQueue.isEmpty()) {
                    ans[i]=priorityQueue.remove()[0];//assign the lake with the highest priority
                    pqSet.remove(ans[i]);//remove also from the set
                }
            } else if (priorities[i]!=0) {
                priorityQueue.add(new Integer[]{rains[i],priorities[i]});
                pqSet.add(rains[i]);
            }
        }
        if (!priorityQueue.isEmpty())return new int[]{};//at the end the priority queue must be empty
        return ans;
    }
}
