class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int[] letterFrequencies = new int[128];

        for (char letter : t.toCharArray()) {
            ++letterFrequencies[letter - 'A'];
        }

        for (int left = 0, right = 0, count = 0; s.length() > right; ++right) {
            --letterFrequencies[s.charAt(right) - 'A'];

            if (0 <= letterFrequencies[s.charAt(right) - 'A']) {
                ++count;
            }

            while (t.length() == count) {
                if (result.isEmpty() || result.length() > 1 + right - left) {
                    result = s.substring(left, 1 + right);
                }

                ++letterFrequencies[s.charAt(left) - 'A'];
                
                if (0 < letterFrequencies[s.charAt(left) - 'A']) {
                    --count;
                }

                ++left;
            }
        }

        return result;
    }
}
