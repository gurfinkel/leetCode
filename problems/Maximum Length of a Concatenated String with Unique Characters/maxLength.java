class Solution {
    public int maxLength(List<String> arr) {
        // Results initialized as a Set to prevent duplicates
        Set<Integer> results = new HashSet<>(){{add(0);}};
        int best = 0;

        // Check each string in arr and find the best length
        for (String word : arr)
            best = Math.max(best, addWord(word, results));
        return best;
    }

    private int addWord(String word, Set<Integer> results) {
        // Initialize an int to use as a character set
        int charBitSet = 0;
        int best = 0;
        for (char c : word.toCharArray()) {
            // Define character mask for currrent char
            int mask = 1 << c - 'a';

            // Bitwise AND check using character mask
            // to see if char already found and if so, exit
            if ((charBitSet & mask) > 0)
                return 0;

            // Mark char as seen in charBitSet
            charBitSet += mask;
        }

        // If the initial bitset is already a known result,
        // then any possible new results will have already been found
        if (results.contains(charBitSet))
            return 0;

        // Iterate through previous results only
        Set<Integer> newResults = new HashSet<>();
        for (Integer res : results) {
            // If the two bitsets overlap, skip to the next result
            if ((res & charBitSet) > 0)
                continue;

            // Build the new entry with bit manipulation
            int newResLen = (res >> 26) + word.length();
            int newCharBitSet = (charBitSet + res) & ((1 << 26) - 1);

            // Merge the two into one, add it to results,
            // and keep track of the longest so far
            newResults.add((newResLen << 26) + newCharBitSet);
            best = Math.max(best, newResLen);
        }
        results.addAll(newResults);
        return best;
    }
}
