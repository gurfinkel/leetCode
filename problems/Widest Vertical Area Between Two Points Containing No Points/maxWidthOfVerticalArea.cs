public class Solution {
    public int MaxWidthOfVerticalArea(int[][] points) {
        var store = new List<int>();
        var result = 0;

        foreach (int[] point in points) {
            store.Add(point[0]);
        }

        store.Sort();

        for (int idx = 1; store.Count > idx; ++idx) {
            result = Math.Max(result, store[idx] - store[idx - 1]);
        }

        return result;
    }
}
