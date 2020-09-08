public class MovingAverage {

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        _store = new Queue<int>();
        _size = size;
        _sum = 0;
    }

    public double Next(int val) {
        if (_size == _store.Count) {
            _sum -= _store.Dequeue();
        }

        _sum += val;
        _store.Enqueue(val);

        return (double)_sum / _store.Count;
    }

    private readonly Queue<int> _store;
    private int _size;
    private int _sum;
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.Next(val);
 */
