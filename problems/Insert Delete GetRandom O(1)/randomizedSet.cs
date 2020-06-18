public class RandomizedSet {
    private Dictionary<int, int> _mapIdxToVal;
    private Dictionary<int, int> _mapValToIdx;
    private Random _random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        _mapIdxToVal = new Dictionary<int, int>();
        _mapValToIdx = new Dictionary<int, int>();
        _random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public bool Insert(int val) {
        if (!_mapValToIdx.ContainsKey(val)) {
            _mapValToIdx.Add(val, _mapValToIdx.Count);
            _mapIdxToVal.Add(_mapIdxToVal.Count, val);

            return true;
        }

        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public bool Remove(int val) {
        if (_mapValToIdx.ContainsKey(val)) {
            int currIdx = _mapValToIdx[val];
            int lastIdx = _mapIdxToVal.Count - 1;
            int lastVal = _mapIdxToVal[lastIdx];

            _mapIdxToVal[currIdx] = lastVal;
            _mapValToIdx[lastVal] = currIdx;
            _mapIdxToVal.Remove(lastIdx);
            _mapValToIdx.Remove(val);

            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int GetRandom() {
        return _mapIdxToVal[_random.Next(_mapIdxToVal.Count)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.Insert(val);
 * bool param_2 = obj.Remove(val);
 * int param_3 = obj.GetRandom();
 */
