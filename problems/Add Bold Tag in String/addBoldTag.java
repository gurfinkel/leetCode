class Solution {
    public String addBoldTag(String s, String[] dict) {
        StringBuilder sb = new StringBuilder();
        boolean[] isLetterFound = new boolean[s.length()];
        boolean bStarted = false;

        for (String word : dict) {
            int idx = s.indexOf(word);

            while (-1 != idx) {
                int len = word.length();

                for (int i = idx; idx + len > i; ++i) {
                    isLetterFound[i] = true;
                }

                idx = s.indexOf(word, 1 + idx);
            }
        }

        for (int idx = 0; s.length() > idx; ++idx) {
            if (isLetterFound[idx]) {
                if (!bStarted) {
                    bStarted = true;
                    sb.append("<b>");
                }
            } else {
                if (bStarted) {
                    bStarted = false;
                    sb.append("</b>");
                }
            }
            sb.append(s.charAt(idx));
        }

        if (bStarted) {
            sb.append("</b>");
        }

        return sb.toString();
    }
}
