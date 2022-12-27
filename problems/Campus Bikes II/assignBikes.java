class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        backtrack(workers, 0, bikes, 0, new boolean[bikes.length]);

        return smallestDistanceSum;
    }

    int smallestDistanceSum = Integer.MAX_VALUE;

    // Manhattan distance
    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private void backtrack(int[][] workers, int workerIdx, int[][] bikes, int sum, boolean[] visitedBikes) {
        if (workers.length == workerIdx) {
            smallestDistanceSum = Math.min(smallestDistanceSum, sum);
            return;
        }

        if (sum >= smallestDistanceSum) {
            return;
        }

        for (int bikeIdx = 0; bikes.length > bikeIdx; ++bikeIdx) {
            if (!visitedBikes[bikeIdx]) {
                visitedBikes[bikeIdx] = true;
                backtrack(workers, 1 + workerIdx, bikes,
                    sum + getDistance(workers[workerIdx], bikes[bikeIdx]), visitedBikes);
                visitedBikes[bikeIdx] = false;
            }
        }
    }
}
