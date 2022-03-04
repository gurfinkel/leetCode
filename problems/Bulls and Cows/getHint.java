class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls = 0;
        int cows = 0;
        int[] guessStore = new int[10];
        int[] secretStore = new int[10];

        for (int idx = 0; n > idx; ++idx) {
            ++guessStore[guess.charAt(idx) - '0'];
            ++secretStore[secret.charAt(idx) - '0'];

            if (secret.charAt(idx) == guess.charAt(idx)) {
                ++bulls;
            }
        }

        for (int idx = 0; 10 > idx; ++idx) {
            cows += Math.min(guessStore[idx], secretStore[idx]);
        }

        return String.format("%sA%sB", bulls, (cows - bulls));
    }
}
