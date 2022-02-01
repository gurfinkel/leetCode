class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse().toString(), ')', '(');

        return result.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(String str, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char symbol : str.toCharArray()) {
            if (open == symbol) {
                ++balance;
            } if (close == symbol) {
                if (balance == 0) {
                    continue;
                }
                --balance;
            }
            sb.append(symbol);
        }
        return sb;
    }
}
