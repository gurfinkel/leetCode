class LRUCache {
    private int _capacity;
    private HashMap<Integer, Node> _store;
    private Node _head;
    private Node _tail;

    public LRUCache(int capacity) {
        _capacity = capacity;
        _store = new HashMap<>();
        _head = new Node();
        _tail = new Node();

        _head.next = _tail;
        _tail.prev = _head;
    }

    public int get(int key) {
        if (!_store.containsKey(key)) {
            return -1;
        }

        Node node = _store.get(key);

        remove(node);
        insertAfter(node, _head);

        return node.value;
    }

    public void put(int key, int value) {
        if (_store.containsKey(key)) {
            Node node = _store.get(key);

            node.value = value;
            remove(node);
            insertAfter(node, _head);
        } else {
            if (_capacity == _store.size()) {
                _store.remove(_tail.prev.key);
                remove(_tail.prev);
            }

            Node node = new Node();

            node.key = key;
            node.value = value;
            insertAfter(node, _head);
            _store.put(key, node);
        }
    }

    private class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insertAfter(Node node, Node head) {
        Node next = head.next;

        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
