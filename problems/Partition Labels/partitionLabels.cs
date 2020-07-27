public class Solution {
    public IList<int> PartitionLabels(string S) {
        int n = S.Length;
        int lastPartEnd = 0;
        int[] letterLastIdx = new int[26];
        List<int> result = new List<int>();

        for (int idx = 0; n > idx; ++idx) {
            letterLastIdx[S[idx] - 'a'] = idx;
        }

        for (int idx = 0, currPartEnd = 0; n > idx; ++idx) {
            currPartEnd = Math.Max(currPartEnd, letterLastIdx[S[idx] - 'a']);

            if (idx == currPartEnd) {
                result.Add(1 + idx - lastPartEnd);
                lastPartEnd = 1 + idx;
            }
        }

        return result;
    }
}
