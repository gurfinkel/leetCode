public class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private readonly Queue<int> _data;
    private readonly int _size;

    public MyCircularQueue(int k) {
        _size = k;
        _data = new Queue<int>();
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public bool EnQueue(int value) {
        if (_size == _data.Count) {
            return false;
        } else {
            _data.Enqueue(value);

            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public bool DeQueue() {
        if (0 == _data.Count) {
            return false;
        } else {
            _data.Dequeue();

            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        return IsEmpty() ? -1 : _data.ToArray()[0];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return IsEmpty() ? -1 : _data.ToArray()[_data.Count - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public bool IsEmpty() {
        return 0 == _data.Count;
    }

    /** Checks whether the circular queue is full or not. */
    public bool IsFull() {
        return _size == _data.Count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * bool param_1 = obj.EnQueue(value);
 * bool param_2 = obj.DeQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * bool param_5 = obj.IsEmpty();
 * bool param_6 = obj.IsFull();
 */
