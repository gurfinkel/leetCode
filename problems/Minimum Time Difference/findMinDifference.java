class Solution {
    public int findMinDifference(List<String> timePoints) {
        Set<Integer> dup = new HashSet<Integer>();
        int[] timeInMins = new int[timePoints.size()];
        for (int i=0; i<timeInMins.length; i++)
        {
            String time = timePoints.get(i);
            int min = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3));
            if (!dup.add(min))
                return 0;
            timeInMins[i] = min;
        }
        Arrays.sort(timeInMins);
        int result = timeInMins[0]+24*60 - timeInMins[timeInMins.length-1];
        for (int i=0; i<timeInMins.length-1; i++)
        {
            result = Math.min(result, timeInMins[i+1]-timeInMins[i]);
        }
        return result;
    }
}
