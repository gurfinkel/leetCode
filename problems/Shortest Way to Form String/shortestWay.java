class Solution {
    public int shortestWay(String source, String target) {
        // Boolean array to mark all characters of source
        boolean[] sourceChars = new boolean[26];
        for (char c : source.toCharArray()) {
            sourceChars[c - 'a'] = true;
        }

        // Check if all characters of target are present in source
        // If any character is not present, return -1
        for (char c : target.toCharArray()) {
            if (!sourceChars[c - 'a']) {
                return -1;
            }
        }

        // Length of source to loop back to start of source using mod
        int m = source.length();

        // Pointer for source
        int sourceIterator = 0;

        // Number of times source is traversed. It will be incremented when
        // while finding occurrence of a character in target, sourceIterator
        // reaches the start of source again.
        int count = 0;

        // Find all characters of target in source
        for (char c : target.toCharArray()) {

            // If while finding, iterator reaches start of source again,
            // increment count
            if (sourceIterator == 0) {
                count++;
            }

            // Find the first occurrence of c in source
            while (source.charAt(sourceIterator) != c) {

                // Formula for incrementing while looping back to start.
                sourceIterator = (sourceIterator + 1) % m;

                // If while finding, iterator reaches start of source again,
                // increment count
                if (sourceIterator == 0) {
                    count++;
                }
            }

            // Loop will break when c is found in source. Thus, increment.
            // Don't increment count until it is not clear that target has
            // remaining characters.
            sourceIterator = (sourceIterator + 1) % m;
        }

        // Return count
        return count;
    }
}
