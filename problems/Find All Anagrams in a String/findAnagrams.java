class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] letterFrequencies = new int[26];
        int letterCounter = 0;
        int pSize = p.length();

        for (char letter : p.toCharArray()) {
            ++letterFrequencies[letter - 'a'];
        }

        for (int idx = 0; s.length() > idx; ++idx) {
            if (0 < letterFrequencies[s.charAt(idx) - 'a']--) {
                ++letterCounter;
            }

            if (pSize <= idx && 0 < ++letterFrequencies[s.charAt(idx - pSize) - 'a']) {
                --letterCounter;
            }

            if (pSize == letterCounter) {
                result.add(1 + idx - pSize);
            }
        }

        return result;
    }
}
