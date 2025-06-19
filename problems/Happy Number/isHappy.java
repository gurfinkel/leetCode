class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (1 != n && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return 1 == n;
    }

    private int getNext(int n) {
        int result = 0;

        while (0 < n) {
            result += (n%10) * (n%10);
            n /= 10;
        }

        return result;
    }
}
