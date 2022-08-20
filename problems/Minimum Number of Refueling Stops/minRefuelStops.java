class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0;
        int prev = 0;

        for (int[] station: stations) {
            int location = station[0];
            int capacity = station[1];

            startFuel -= location - prev;

            while (!pq.isEmpty() && 0 > startFuel) {  // must refuel in past
                startFuel += pq.poll();
                ans++;
            }

            if (0 > startFuel) {
                return -1;
            }
            pq.offer(capacity);
            prev = location;
        }

        startFuel -= target - prev;
        while (!pq.isEmpty() && 0 > startFuel) {
            startFuel += pq.poll();
            ans++;
        }
        if (0 > startFuel) {
            return -1;
        }

        return ans;
    }
}
