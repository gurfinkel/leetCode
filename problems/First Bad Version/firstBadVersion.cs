/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    public int FirstBadVersion(int n) {
        var l = 1;
        var r = n;

        while (l <= r) {
            var mid = l + ((r - l) >> 1);

            if (IsBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
