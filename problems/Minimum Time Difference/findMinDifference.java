class Solution {
    public int findMinDifference(List<String> timePoints) {
        HashSet<Integer> store = new HashSet<>();
        int[] timeInMins = new int[timePoints.size()];

        for (int idx = 0; timeInMins.length > idx; ++idx) {
            String timePoint = timePoints.get(idx);
            int time = 60 * Integer.parseInt(timePoint.substring(0, 2)) + Integer.parseInt(timePoint.substring(3));

            if (store.contains(time)) {
                return 0;
            }

            store.add(time);
            timeInMins[idx] = time;
        }

        Arrays.sort(timeInMins);

        int result = 24*60 + timeInMins[0] - timeInMins[timeInMins.length - 1];

        for (int idx = 1; timeInMins.length > idx; ++idx) {
            result = Math.min(result, timeInMins[idx] - timeInMins[idx - 1]);
        }

        return result;
    }
}
