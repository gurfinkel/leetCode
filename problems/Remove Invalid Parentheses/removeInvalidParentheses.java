class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (char symbol : s.toCharArray()) {
            if ('(' == symbol) {
                ++left;
            } else if (')' == symbol) {
                if (0 < left) {
                    --left;
                } else {
                    ++right;
                }
            }
        }

        dfs(s, 0, left, right, result);

        return result;
    }

    private void dfs(String s, int start, int leftToRemove, int rightToRemove, List<String> result) {
        // System.out.println(s + " " + leftToRemove + " " + rightToRemove + " " + start);
        if (0 > leftToRemove || 0 > rightToRemove) {
            return;
        }

        if (0 == leftToRemove && 0 == rightToRemove) {
            if (isValid(s)) {
                result.add(s);
            }

            return;
        }

        for (int idx = start; s.length() > idx; ++idx) {
            char symbol = s.charAt(idx);
            //don't need to try because will generate same string when remove one from multiple brackets
            if (0 < idx && s.charAt(idx - 1) == symbol) {
                continue;
            }

            if (0 < leftToRemove && '(' == symbol) {
                dfs(s.substring(0, idx) + s.substring(idx + 1), idx, leftToRemove - 1, rightToRemove, result);
            } else if (0 < rightToRemove && ')' == symbol) {
                dfs(s.substring(0, idx) + s.substring(idx + 1), idx, leftToRemove, rightToRemove - 1, result);
            }
        }
    }

    private boolean isValid(String s) {
        if (null == s || 0 == s.length()) {
            return true;
        }

        int left = 0;

        for (char symbol : s.toCharArray()) {
            if ('(' == symbol) {
                ++left;
            } else if (')' == symbol) {
                if (0 >= left) {
                    return false;
                }

                --left;
            }
        }
        return 0 == left;
    }
}
