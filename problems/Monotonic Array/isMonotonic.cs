public class Solution {
    public bool IsMonotonic(int[] A) {
        if (1 == A.Length) {
            return true;
        }

        var diff = A[0] - A[1];

        for (var i = 1; A.Length > i; ++i) {
            var currDiff = A[i - 1] - A[i];

            if (0 == currDiff) {
                continue;
            } else if (0 == diff) {
                diff = currDiff;
            } else if (Math.Sign(diff) != Math.Sign(currDiff)) {
                return false;
            }
        }

        return true;
    }
}
