public class Solution {
    public int HIndex(int[] citations) {
        Array.Sort(citations);

        int n = citations.Length;

        for (int idx = 0; n > idx; ++idx) {
            if (citations[idx] >= n - idx) {
                return n - idx;
            }
        }

        return 0;
    }
}
