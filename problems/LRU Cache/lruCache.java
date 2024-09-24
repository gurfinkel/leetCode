class LRUCache {

    public LRUCache(int capacity) {
        size = capacity;
        keyToNodeMap = new HashMap<>();
        fakeHead = new Node();
        fakeTail = new Node();

        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }
        
        Node node = keyToNodeMap.get(key);

        remove(node);
        insertAfter(node, fakeHead);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);

            node.value = value;
            remove(node);
            insertAfter(node, fakeHead);
        } else {
            if (size == keyToNodeMap.size()) {
                keyToNodeMap.remove(fakeTail.prev.key);
                remove(fakeTail.prev);
            }

            Node node = new Node();

            node.key = key;
            node.value = value;
            insertAfter(node, fakeHead);
            keyToNodeMap.put(key, node);
        }
    }

    int size;
    HashMap<Integer, Node> keyToNodeMap;
    Node fakeHead;
    Node fakeTail;

    class Node {
        Node prev;
        Node next;
        int key;
        int value;
    }

    void insertAfter(Node node, Node head) {
        Node next = head.next;
        
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
