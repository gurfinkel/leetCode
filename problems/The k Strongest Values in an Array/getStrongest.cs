public class Solution {
    public int[] GetStrongest(int[] arr, int k) {
        var n = arr.Length;
        var result = new List<int>();

        Array.Sort(arr);

        var median = arr[(n - 1) >> 1];
        var l = 0;
        var r = n - 1;

        while (k > result.Count) {
            if (Math.Abs(median - arr[l]) > Math.Abs(median - arr[r])) {
                result.Add(arr[l++]);
            } else if (Math.Abs(median - arr[l]) < Math.Abs(median - arr[r])) {
                result.Add(arr[r--]);
            } else {
                if (arr[l] > arr[r]) {
                    result.Add(arr[l++]);
                } else {
                    result.Add(arr[r--]);
                }
            }
        }

        return result.ToArray();
    }
}
