class Solution {
    public String addBoldTag(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean[] letterFound = new boolean[n];
        boolean bOpened = false;

        for (String word : words) {
            int idx = s.indexOf(word);

            while (-1 != idx) {
                for (int i = 0; word.length() > i; ++i) {
                    letterFound[idx + i] = true;
                }

                idx = s.indexOf(word, 1 + idx);
            }
        }

        for (int idx = 0; n > idx; ++idx) {
            if (letterFound[idx]) {
                if (!bOpened) {
                    sb.append("<b>");
                    bOpened = true;
                }
            } else {
                if (bOpened) {
                    sb.append("</b>");
                    bOpened = false;
                }
            }

            sb.append(s.charAt(idx));
        }

        if (bOpened) {
            sb.append("</b>");
        }

        return sb.toString();
    }
}
