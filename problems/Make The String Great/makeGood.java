class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (0 == sb.length()) {
                sb.append(letter);
            } else {
                if ((isUpper(letter) && sb.charAt(sb.length() - 1) == Character.toLowerCase(letter)) ||
                   (isLower(letter) && sb.charAt(sb.length() - 1) == Character.toUpperCase(letter))) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(letter);
                }
            }
        }

        return sb.toString();
    }

    private boolean isUpper(char letter) {
        return 'A' <= letter && 'Z' >= letter;
    }

    private boolean isLower(char letter) {
        return 'a' <= letter && 'z' >= letter;
    }
}
