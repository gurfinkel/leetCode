class LRUCache {

    public LRUCache(int capacity) {
        size = capacity;
        store = new HashMap<>();
        fakeHead = new Node();
        fakeTail = new Node();

        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }

    public int get(int key) {
        if (!store.containsKey(key)) {
            return -1;
        }

        Node node = store.get(key);

        remove(node);
        insertAfter(node, fakeHead);

        return node.value;
    }

    public void put(int key, int value) {
        if (store.containsKey(key)) {
            Node node = store.get(key);

            node.value = value;
            remove(node);
            insertAfter(node, fakeHead);
        } else {
            if (size == store.size()) {
                store.remove(fakeTail.prev.key);
                remove(fakeTail.prev);
            }

            Node node = new Node();

            node.key = key;
            node.value = value;
            insertAfter(node, fakeHead);
            store.put(key, node);
        }
    }

    int size;
    HashMap<Integer, Node> store;
    Node fakeHead;
    Node fakeTail;

    class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    void insertAfter(Node node, Node head) {
        Node next = head.next;

        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
