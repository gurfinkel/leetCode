class Solution {
    public String customSortString(String order, String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int[] letterFrequencies = new int[26];

        for (char letter : str.toCharArray()) {
            ++letterFrequencies[letter - 'a'];
        }

        for (char letter : order.toCharArray()) {
            while (0 < letterFrequencies[letter - 'a']--) {
                sb.append(letter);
            }
        }

        for (int idx = 0; letterFrequencies.length > idx; ++idx) {
            while (0 < letterFrequencies[idx]--) {
                sb.append((char) ('a' + idx));
            }
        }

        return sb.toString();
    }
}
