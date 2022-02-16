class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (0 == num.length() || Integer.MAX_VALUE < Long.valueOf(num)) {
            return result;
        }

        char[] path = new char[2 * num.length() - 1];
        int n = 0;

        for (int idx = 0; num.length() > idx; ++idx) {
            n *= 10;
            n += num.charAt(idx) - '0';
            path[idx] = num.charAt(idx);
            dfs(num, 1 + idx, path, 1 + idx, 0, n, target, result);

            if (0 == n) {
                break;
            }
        }

        return result;
    }

    void dfs(String num, int numIdx, char[] path, int pathIdx, int left, int curr, int target, List<String> result) {
        if (num.length() == numIdx) {
            if (target == left + curr) {
                result.add(new String(path, 0, pathIdx));
            }
            return;
        }

        int n = 0;
        int j = 1 + pathIdx;

        for (int idx = numIdx; num.length() > idx; ++idx) {
            n *= 10;
            n += num.charAt(idx) - '0';

            path[j++] = num.charAt(idx);
            path[pathIdx] = '+';
            dfs(num, 1 + idx, path, j, left+curr, n, target, result);

            path[pathIdx] = '-';
            dfs(num, 1 + idx, path, j, left+curr, -n, target, result);

            path[pathIdx] = '*';
            dfs(num, 1 + idx, path, j, left, curr*n, target, result);

            if (0 == n) {
                break;
            }
        }
    }
}
