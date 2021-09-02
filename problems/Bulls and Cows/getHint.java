class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] keepSecret = new int[10];
        int bulls = 0;
        int cows = 0;

        for (int idx = 0; n > idx; ++idx) {
            if(secret.charAt(idx) == guess.charAt(idx)) {
                ++bulls;
            } else {
                ++keepSecret[secret.charAt(idx) - '0'];
            }
        }

        for (int idx = 0; n > idx; ++idx) {
            if (0 < keepSecret[guess.charAt(idx) - '0'] && secret.charAt(idx) != guess.charAt(idx)) {
                --keepSecret[guess.charAt(idx) - '0'];
                ++cows;
            }
        }

        return String.format("%sA%sB", bulls, cows);
    }
}
