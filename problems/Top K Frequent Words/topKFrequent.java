class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        HashMap<String, Integer> wordFrequenties = new HashMap<String, Integer>();
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
            (a,b) -> wordFrequenties.get(a) == wordFrequenties.get(b)
            ? b.compareTo(a)
            : wordFrequenties.get(a) - wordFrequenties.get(b)
        );

        for (String word : words) {
            wordFrequenties.put(word, 1 + wordFrequenties.getOrDefault(word, 0));
        }

        for (String key : wordFrequenties.keySet()) {
            minHeap.add(key);

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
