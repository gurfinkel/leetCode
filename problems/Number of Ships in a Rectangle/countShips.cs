/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public bool HasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int CountShips(Sea sea, int[] rt, int[] lb) {
        int l = lb[0];
        int b = lb[1];
        int r = rt[0];
        int t = rt[1];

        if (!sea.HasShips(rt, lb)) return 0;
        if (l == r && b == t) return 1;

        int x = l + (r - l) / 2;
        int y = b + (t - b) / 2;

        return
            CountShips(sea, new int[] {r, t}, new int[] {x + 1, y + 1}) +
            CountShips(sea, new int[] {x, t}, new int[] {l, y + 1}) +
            CountShips(sea, new int[] {x, y}, new int[] {l, b}) +
            CountShips(sea, new int[] {r, y}, new int[] {x + 1, b});
    }
}
