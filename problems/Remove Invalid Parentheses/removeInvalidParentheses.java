class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();

        backtrack(s, 0, 0, 0, new StringBuilder(), 0, result);

        return new ArrayList(result);
    }

    private int minRemoved = Integer.MAX_VALUE;

    private void backtrack(String s, int idx, int left, int right, StringBuilder sb, int removed, Set<String> result) {
        if (s.length() == idx) {
            if (left == right && removed <= this.minRemoved) {
                if (removed < this.minRemoved) {
                    this.minRemoved = removed;
                    result.clear();
                }

                result.add(sb.toString());
            }
        } else {
            char letter = s.charAt(idx);
            int len = sb.length();

            if ('(' != letter && ')' != letter) {
                sb.append(letter);
                backtrack(s, 1 + idx, left, right, sb, removed, result);
                sb.deleteCharAt(len);
            } else {
                backtrack(s, 1 + idx, left, right, sb, 1 + removed, result);
                sb.append(letter);

                if ('(' == letter) {
                    backtrack(s, 1 + idx, 1 + left, right, sb, removed, result);
                } else if (left > right) {
                    backtrack(s, 1 + idx, left, 1 + right, sb, removed, result);
                }

                sb.deleteCharAt(len);
            }
        }
    }
}
