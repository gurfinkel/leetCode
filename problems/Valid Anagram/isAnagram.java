class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letterFrequencies = new int[26];

        for (int idx = 0; s.length() > idx; ++idx) {
            ++letterFrequencies[s.charAt(idx) - 'a'];
            --letterFrequencies[t.charAt(idx) - 'a'];
        }

        for (int item : letterFrequencies) {
            if (0 != item) {
                return false;
            }
        }

        return true;
    }
}
