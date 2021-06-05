class Solution {
    public String frequencySort(String s) {
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        MaxHeap maxHeap = new MaxHeap();
        HashMap<Character, Integer> store = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char letter : s.toCharArray()) {
            store.put(letter, 1 + store.getOrDefault(letter, 0));
        }

        for (char letter : store.keySet()) {
            // maxHeap.add(new int[] {letter - 'a', store.get(letter)});
            maxHeap.add(new Node(letter, store.get(letter)));
        }

        while (!maxHeap.isEmpty()) {
//             int[] item = maxHeap.poll();
//             int count = item[1];

//             while (0 < count--) {
//                 sb.append((char)('a' + item[0]));
//             }

            Node item = maxHeap.poll();

            while (0 < item.count--) {
                sb.append(item.letter);
            }
        }

        return sb.toString();
    }

    private class Node {
        public char letter;
        public int count;

        public Node(char l, int c) {
            letter = l;
            count = c;
        }
    }

    private class MaxHeap {
        private List<Node> _store = new ArrayList<>();

        public MaxHeap() {}

        public int size() {
            return _store.size();
        }

        public boolean isEmpty() {
            return 0 == size();
        }

        public Node poll() {
            Node top = _store.get(0);

            swap(0, size() - 1);
            _store.remove(size() - 1);

            siftDown(0);

            return top;
        }

        public void add(Node node) {
            _store.add(node);

            siftUp(size() - 1);
        }

        private void siftUp(int i) {
            while (_store.get((i - 1) / 2).count < _store.get(i).count) {
                swap((i - 1) / 2, i);
                i = (i - 1) / 2;
            }
        }

        private void siftDown(int i) {
            while (size() > 1 + 2 * i) {
                int biggestChildIdx = 1 + 2 * i;

                if (size() > 2 + 2 * i && _store.get(1 + 2 * i).count < _store.get(2 + 2 * i).count) {
                    biggestChildIdx = 2 + 2 * i;
                }

                if (_store.get(i).count > _store.get(biggestChildIdx).count) {
                    break;
                } else {
                    swap(i, biggestChildIdx);
                    i = biggestChildIdx;
                }
            }
        }

        private void swap(int i, int j) {
            Node tmp = _store.get(i);
            _store.set(i, _store.get(j));
            _store.set(j, tmp);
        }
    }
}
