class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pLetterFrequencies = new int[26];
        int[] sLetterFrequencies = new int[26];
        List<Integer> result = new ArrayList<Integer>();

        for (char letter : p.toCharArray()) {
            ++pLetterFrequencies[letter - 'a'];
        }

        for (int i = 0; s.length() > i; ++i) {
            ++sLetterFrequencies[s.charAt(i) - 'a'];

            if (i >= p.length()) {
                --sLetterFrequencies[s.charAt(i - p.length()) - 'a'];
            }

            if (Arrays.equals(sLetterFrequencies, pLetterFrequencies)) {
                result.add(1 + i - p.length());
            }
        }

        return result;
    }
}
