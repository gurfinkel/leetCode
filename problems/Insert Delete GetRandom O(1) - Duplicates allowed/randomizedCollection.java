class RandomizedCollection {
    ArrayList<Integer> _store;
    HashMap<Integer, Set<Integer>> _map;
    Random _random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        _store = new ArrayList<Integer>();
        _map = new HashMap<Integer, Set<Integer>>();
        _random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!_map.containsKey(val)) {
            _map.put(val, new LinkedHashSet<Integer>());
        }

        _map.get(val).add(_store.size());
        _store.add(val);

        return 1 == _map.get(val).size();
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!_map.containsKey(val) || 0 == _map.get(val).size()) {
            return false;
        }

        int remove_idx = _map.get(val).iterator().next();
        int last = _store.get(_store.size() - 1);

        _store.set(remove_idx, last);
        _map.get(val).remove(remove_idx);
        _map.get(last).add(remove_idx);
        _map.get(last).remove(_store.size() - 1);

        _store.remove(_store.size() - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return _store.get(_random.nextInt(_store.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
