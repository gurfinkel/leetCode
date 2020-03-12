public class LRUCache {

    public LRUCache(int capacity)
    {
        _capacity = capacity;
        _lru = new LinkedList<int>();
        _data = new Dictionary<int, (int, LinkedListNode<int>)>();
    }

    public int Get(int key)
    {
        (int, LinkedListNode<int>) val;
        if(_data.TryGetValue(key, out val))
        {
            _lru.Remove(val.Item2);
            var newNode = _lru.AddFirst(key);
            _data[key] = (val.Item1, newNode);
            return val.Item1;
        }

        return -1;
    }

    public void Put(int key, int newValue)
    {
        (int, LinkedListNode<int>) val;
        LinkedListNode<int> newNode = null;
        if (_data.TryGetValue(key, out val))
        {
            _lru.Remove(val.Item2);
            newNode = _lru.AddFirst(key);
            _data[key] = (newValue, newNode);
            return;
        }

        if (_lru.Count == _capacity)
        {
            var last = _lru.Last;
            _lru.Remove(last);
            _data.Remove(last.Value);
        }

        newNode = _lru.AddFirst(key);
        _data[key] = (newValue, newNode);
    }

    private readonly int _capacity;
    private readonly LinkedList<int> _lru;
    private readonly IDictionary<int, (int, LinkedListNode<int>)> _data;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */
