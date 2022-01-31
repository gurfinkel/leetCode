class Solution {
    public int[] findBuildings(int[] heights) {
        int maxSoFar = 0;
        List<Integer> items = new ArrayList<>();

        for (int idx = heights.length - 1; 0 <= idx; --idx) {
            if (maxSoFar < heights[idx]) {
                items.add(idx);
                maxSoFar = heights[idx];
            }
        }

        int[] result = new int[items.size()];
        int idx = items.size();

        for (int item : items) {
            result[--idx] = item;
        }

        return result;
    }
}
