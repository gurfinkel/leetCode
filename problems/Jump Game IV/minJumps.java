class Solution {
    public int minJumps(int[] arr) {
        if (1 >= arr.length) {
            return 0;
        }

        int n = arr.length;
        int step = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> curs = new LinkedList<>();

        curs.add(0);

        for (int idx = 0; n > idx; ++idx) {
            graph.computeIfAbsent(arr[idx], v -> new LinkedList<>()).add(idx);
        }

        // when current layer exists
        while (!curs.isEmpty()) {
            List<Integer> next = new LinkedList<>();

            // iterate the layer
            for (int node : curs) {
                // check if reached end
                if (n - 1 == node) {
                    return step;
                }

                // check same value
                for (int child : graph.get(arr[node])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        next.add(child);
                    }
                }

                // clear the list to prevent redundant search
                graph.get(arr[node]).clear();

                // check neighbors
                if (n > 1 + node && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    next.add(node + 1);
                }
                if (0 <= node - 1 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    next.add(node - 1);
                }
            }

            curs = next;
            ++step;
        }

        return -1;
    }
}
