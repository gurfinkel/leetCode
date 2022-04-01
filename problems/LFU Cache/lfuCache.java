class LFUCache {

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freq = new HashMap<>();
        nodes = new HashMap<>();
        lists = new HashMap<>();
        lists.put(0, new MyList());
    }

    public int get(int key) {
        if (capacity == 0 || !freq.containsKey(key)) {
            return -1;
        }
        freq.merge(key, +1, Integer::sum);
        int f = freq.get(key);
        Node node = remove(f - 1, key);
        if (f > lists.size()) {
            lists.put(f, new MyList());
        }
        add(f, node);
        updateMinFreq(f);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        freq.merge(key, +1, Integer::sum);
        int f = freq.get(key);
        if(f == 1) {
            size++;
        } else {
            remove(f - 1, key);
        }
        Node node = new Node(key, value);
        nodes.put(key, node);
        add(f, node);
        if(size > capacity) {
            removeOldest();
        }
        updateMinFreq(f);
    }

    class MyList {
        final Node head = new Node(-1, -1);
        Node tail = head;

        void add(Node node) {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = tail.next;
        }

        void remove(Node node) {
            if(node == tail) {
                tail = tail.prev;
            }
            node.prev.next = node.next;
            if(node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = node.next = null;
        }

        boolean isEmpty() {
            return head == tail;
        }
    }

    class Node {
        int freq;
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node(int key, int val, Node prev, Node next) {
            this(key, val);
            this.prev = prev;
            this.next = next;
        }
    }

    Map<Integer, Integer> freq; // map from key to freq
    Map<Integer, MyList> lists; // map from freq to linked list
    Map<Integer, Node> nodes;   // map from key to node
    int capacity;
    int size;
    int minfreq;

    private void updateMinFreq(int f) {
        if(minfreq == 0) {
            minfreq = f;
            return;
        }
        minfreq = Math.min(minfreq, f);
        if(!lists.containsKey(minfreq) || lists.get(minfreq).isEmpty()) {
            minfreq++;
        }
    }

    private Node remove(int f, int key) {
        MyList list = lists.get(f);
        Node node = nodes.get(key);
        list.remove(node);
        return node;
    }

    private void add(int f, Node node) {
        if(!lists.containsKey(f)) {
            lists.put(f, new MyList());
        }
        lists.get(f).add(node);
    }

    private void removeOldest() {
        MyList list = lists.get(minfreq);
        if(list.isEmpty()) {
            return;
        }
        Node node = list.head.next;
        updateMinFreq(freq.get(node.key));
        freq.remove(node.key);
        list.remove(node);
        size--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
