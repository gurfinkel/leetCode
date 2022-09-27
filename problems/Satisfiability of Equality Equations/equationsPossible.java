class Solution {
    public boolean equationsPossible(String[] equations) {
        List<Integer>[] graph = new ArrayList[26];
        int[] color = new int[26];

        Arrays.fill(color, -1);

        for (int idx = 0; 26 > idx; ++idx) {
            graph[idx] = new ArrayList();
        }

        for (String eqn : equations) {
            if ('=' == eqn.charAt(1)) {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                graph[x].add(y);
                graph[y].add(x);
            }
        }

        for (int idx = 0; 26 > idx; ++idx) {
            if (-1 == color[idx]) {
                dfs(idx, idx, color, graph);
            }
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';

                if (color[x] == color[y]) {
                    return false;
                }
            }
        }

        return true;
    }

    // mark the color of `node` as `c`
    private static void dfs(int node, int c, int[] color, List<Integer>[] graph) {
        if (-1 == color[node]) {
            color[node] = c;
            for (int nei : graph[node]) {
                dfs(nei, c, color, graph);
            }
        }
    }
}
