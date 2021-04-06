class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int aIdx = 0;
        int bIdx = 0;

        while (firstList.length > aIdx && secondList.length > bIdx) {
            int x = Math.max(firstList[aIdx][0], secondList[bIdx][0]);
            int y = Math.min(firstList[aIdx][1], secondList[bIdx][1]);

            if (x <= y) {
                result.add(new int[] {x, y});
            }

            if (firstList[aIdx][1] < secondList[bIdx][1]) {
                ++aIdx;
            } else {
                ++bIdx;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
