public class Solution {
    public int CountElements(int[] arr) {
        var result = 0;
        var counter = 1;

        Array.Sort(arr);

        for (var i = 1; arr.Length > i; ++i) {
            if (arr[i - 1] == arr[i]) {
                ++counter;
            } else if (1 + arr[i - 1] == arr[i]) {
                result += counter;
                counter = 1;
            } else {
                counter = 1;
            }
        }

        return result;
    }
}
