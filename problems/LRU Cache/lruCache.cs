public class LRUCache {

    public LRUCache(int capacity) {
        _capacity = capacity;
        _store = new Dictionary<int, ListNode>();

        _head.Next = _tail;
        _tail.Prev = _head;
    }

    public int Get(int key) {
        if (!_store.ContainsKey(key)) {
            return -1;
        }

        var currNode = _store[key];

        removeFromList(currNode);
        insertOnTop(currNode);

        return currNode.Value;
    }

    public void Put(int key, int value) {
        if (_store.ContainsKey(key)) {
            var currNode = _store[key];

            removeFromList(currNode);
            insertOnTop(currNode);

            currNode.Value = value;
        } else {
            var newNode = new ListNode {Key = key, Value = value};

            insertOnTop(newNode);
            _store.Add(key, newNode);
        }

        if (_capacity < _store.Count) {
            _store.Remove(_tail.Prev.Key);

            _tail.Prev.Prev.Next = _tail;
            _tail.Prev = _tail.Prev.Prev;
        }
    }

    private void insertOnTop(ListNode node) {
        _head.Next.Prev = node;
        node.Next = _head.Next;
        node.Prev = _head;
        _head.Next = node;
    }

    private void removeFromList(ListNode node) {
        node.Prev.Next = node.Next;
        node.Next.Prev = node.Prev;
    }

    private int _capacity;
    private Dictionary<int, ListNode> _store;
    private ListNode _head = new ListNode();
    private ListNode _tail = new ListNode();

    private class ListNode {
        public int Key {get; set;}
        public int Value {get; set;}
        public ListNode Prev {get; set;}
        public ListNode Next {get; set;}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */
