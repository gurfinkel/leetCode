class Solution {
    public boolean checkValidString(String s) {
        int openParenthesis = 0;
        int closeParenthesis = 0;

        for (char letter : s.toCharArray()) {
            openParenthesis += '(' == letter ? 1 : -1;
            closeParenthesis += ')' != letter ? 1 : -1;

            if (0 > closeParenthesis) {
                break;
            }

            openParenthesis = Math.max(0, openParenthesis);
        }

        return 0 == openParenthesis;
    }
}
