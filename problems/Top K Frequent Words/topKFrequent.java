class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFrequencies = new HashMap();
        PriorityQueue<String> heap = new PriorityQueue<String> (
            (a, b) -> wordFrequencies.get(a) == wordFrequencies.get(b) ?
            b.compareTo(a) : wordFrequencies.get(a) - wordFrequencies.get(b)
        );
        List<String> result = new ArrayList();

        for (String word : words) {
            wordFrequencies.put(word, 1 + wordFrequencies.getOrDefault(word, 0));
        }

        for (String word : wordFrequencies.keySet()) {
            heap.offer(word);

            if (k < heap.size()) {
                heap.poll();
            }
        }

        while (0 < heap.size()) {
            result.add(0, heap.poll());
        }

        return result;
    }
}
