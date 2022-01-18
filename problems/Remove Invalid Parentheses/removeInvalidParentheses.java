class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<>();

        backtrack(s, 0, 0, 0, new StringBuilder(), result);

        return new ArrayList(result);
    }

    private void backtrack(String s, int idx, int left, int right, StringBuilder sb, HashSet<String> result) {
        if (s.length() == idx) {
            if (left == right) {
                if (result.isEmpty() || sb.length() == result.iterator().next().length()) {
                    result.add(sb.toString());
                } else if (sb.length() > result.iterator().next().length()) {
                    result.clear();
                    result.add(sb.toString());
                }
            }
        } else {
            char symbol = s.charAt(idx);

            if ('(' != symbol && ')' != symbol) {
                sb.append(symbol);
                backtrack(s, 1 + idx, left, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                backtrack(s, 1 + idx, left, right, sb, result);
                sb.append(symbol);

                if ('(' == symbol) {
                    backtrack(s, 1 + idx, 1 + left, right, sb, result);
                } else if (left > right) {
                    backtrack(s, 1 + idx, left, 1 + right, sb, result);
                }

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
