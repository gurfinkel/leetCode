public class MyHashSet {

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void Add(int key) {
        if (!_store.Contains(key)) _store.Add(key);
    }

    public void Remove(int key) {
        if (_store.Contains(key)) _store.Remove(key);
    }

    /** Returns true if this set contains the specified element */
    public bool Contains(int key) {
        return _store.Contains(key);
    }

    private HashSet<int> _store = new HashSet<int>();
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */
