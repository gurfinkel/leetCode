public class FirstUnique {

    public FirstUnique(int[] nums) {
        foreach (var item in nums) {
            _queue.Enqueue(item);

            if (_hash.ContainsKey(item)) {
                ++_hash[item];
            } else {
                _hash.Add(item, 1);
            }
        }
    }

    public int ShowFirstUnique() {
        if (0 == _queue.Count) {
            return -1;
        }

        var item = _queue.Peek();

        while (0 < _queue.Count) {
            item = _queue.Peek();

            if (1 < _hash[item]) {
                _queue.Dequeue();
            } else {
                break;
            }
        }

        return 1 == _hash[item] ? item : -1;
    }

    public void Add(int value) {
        _queue.Enqueue(value);

        if (_hash.ContainsKey(value)) {
            ++_hash[value];
        } else {
            _hash.Add(value, 1);
        }
    }

    private Dictionary<int, int> _hash = new Dictionary<int, int>();
    private Queue<int> _queue = new Queue<int>();
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.ShowFirstUnique();
 * obj.Add(value);
 */
