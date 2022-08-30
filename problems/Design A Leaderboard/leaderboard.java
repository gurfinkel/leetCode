class Leaderboard {

    public Leaderboard() {
        scores = new HashMap<Integer, Integer>();
    }

    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        int result = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));

        for (int key : scores.keySet()) {
            heap.add(new int[] {key, scores.get(key)});
            if (K < heap.size()) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            result += heap.poll()[1];
        }

        return result;
    }

    public void reset(int playerId) {
        scores.put(playerId, 0);
    }

    private HashMap<Integer, Integer> scores;
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */