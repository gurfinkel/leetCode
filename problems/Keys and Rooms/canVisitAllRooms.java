class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        Queue<List<Integer>> bfs = new LinkedList<>();
        int i = 0;

        while (n > i) {
            if (0 != rooms.get(i).size()) {
                bfs.add(rooms.get(i));
                visited.add(i);
                break;
            }
            ++i;
        }

        while (!bfs.isEmpty()) {
            List<Integer> node = bfs.poll();

            for (int item : node) {
                if (!visited.contains(item)) {
                    visited.add(item);
                    bfs.add(rooms.get(item));
                }
            }
        }

        return n == visited.size();
    }
}
