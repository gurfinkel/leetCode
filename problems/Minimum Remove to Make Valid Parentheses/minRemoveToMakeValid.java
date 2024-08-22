class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = removeToMakeValid(s, '(', ')');

        result = removeToMakeValid(result.reverse().toString(), ')', '(');

        return result.reverse().toString();
    }

    private StringBuilder removeToMakeValid(String s, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char symbol : s.toCharArray()) {
            if (open == symbol) {
                ++balance;
            } else if (close == symbol) {
                if (0 == balance) {
                    continue;
                }

                --balance;
            }

            sb.append(symbol);
        }

        return sb;
    }
}
