public class Solution {
    public bool IsHappy(int n) {
        var store = new HashSet<int>();

        while (1 != n && !store.Contains(n)) {
            store.Add(n);
            n = getNext(n);
        }

        return 1 == n;
    }

    private int getNext(int n) {
        var result = 0;

        while (0 < n) {
            result += (n%10) * (n%10);
            n /= 10;
        }

        return result;
    }
}
