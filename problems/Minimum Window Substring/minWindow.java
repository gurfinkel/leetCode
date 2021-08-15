class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int[] letterFrequencies = new int[128];

        for (char letter : t.toCharArray()) {
            ++letterFrequencies[letter - 'A'];
        }

        for (int left = 0, right = 0, count = 0; s.length() > right; ++right) {
            char letter = s.charAt(right);

            if (0 < letterFrequencies[letter - 'A']--) {
                ++count;
            }

            while (t.length() == count) {
                if (0 == result.length() || result.length() > 1 + right - left) {
                    result = s.substring(left, 1 + right);
                }
                if (0 < ++letterFrequencies[s.charAt(left++) - 'A']) {
                    --count;
                }
            }
        }

        return result;
    }
}
