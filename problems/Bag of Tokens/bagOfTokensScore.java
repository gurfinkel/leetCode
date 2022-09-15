class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int result = 0;
        int left = 0;
        int right = tokens.length - 1;
        int points = 0;

        Arrays.sort(tokens);

        while (left <= right && (power >= tokens[left] || 0 < points)) {
            while (left <= right && power >= tokens[left]) {
                power -= tokens[left++];
                ++points;
            }

            result = Math.max(result, points);

            if (left <= right && 0 < points) {
                power += tokens[right--];
                --points;
            }
        }

        return result;
    }
}
