class MyCircularQueue {

    public MyCircularQueue(int k) {
        _size = k;
        _store = new LinkedList<>();
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            _store.add(value);
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            _store.poll();
            return true;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : _store.getFirst();
    }

    public int Rear() {
        return isEmpty() ? -1 : _store.getLast();
    }

    public boolean isEmpty() {
        return 0 == _store.size();
    }

    public boolean isFull() {
        return _size == _store.size();
    }

    private int _size;
    private LinkedList<Integer> _store;
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
