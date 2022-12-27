class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> store = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->{
            if (store.get(a) == store.get(b)) {
                return b - a;
            }
            return store.get(a) - store.get(b);
        });
        int n = report.length;
        HashSet<String> positive_words = new HashSet<>(Arrays.asList(positive_feedback));
        HashSet<String> negative_words = new HashSet<>(Arrays.asList(negative_feedback));

        for (int idx = 0; n > idx; ++idx) {
            int id = student_id[idx];
            String[] items = report[idx].split(" ");
            int score = 0;

            for (String item : items) {
                if (positive_words.contains(item)) {
                    score += 3;
                }
                if (negative_words.contains(item)) {
                    score -= 1;
                }
            }

            store.put(id, score);
        }

        for (int id : student_id) {
            minHeap.add(id);

            if (k < minHeap.size()) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll());
        }

        return result;
    }
}
