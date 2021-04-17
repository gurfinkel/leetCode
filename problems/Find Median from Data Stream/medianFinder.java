class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        _maxHeap = new PriorityQueue<>((a, b) -> a - b);
        _minHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        _maxHeap.add(num);
        _minHeap.add(_maxHeap.poll());

        if (_maxHeap.size() < _minHeap.size()) {
            _maxHeap.add(_minHeap.poll());
        }
    }

    public double findMedian() {
        return _maxHeap.size() > _minHeap.size() ? _maxHeap.peek() : 0.5 * (_maxHeap.peek() + _minHeap.peek());
    }

    PriorityQueue<Integer> _maxHeap;
    PriorityQueue<Integer> _minHeap;
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
