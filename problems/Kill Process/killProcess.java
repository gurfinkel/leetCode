class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        Queue<Integer> bfs = new LinkedList<>();

        for (int idx = 0; ppid.size() > idx; ++idx) {
            if (0 != ppid.get(idx)) {
                List<Integer> children = store.getOrDefault(ppid.get(idx), new ArrayList<>());

                children.add(pid.get(idx));
                store.put(ppid.get(idx), children);
            }
        }

        bfs.add(kill);

        while (!bfs.isEmpty()) {
            int id = bfs.poll();

            result.add(id);

            if (store.containsKey(id)) {
                for (int childId : store.get(id)) {
                    bfs.add(childId);
                }
            }
        }

        return result;
    }
}
