class MovingAverage {

    public MovingAverage(int size) {
        k = size;
        sum = 0;
        store = new LinkedList<>();
    }

    public double next(int val) {
        if (k == store.size()) {
            sum -= store.poll();
        }

        store.add(val);
        sum += val;

        return (double)sum/store.size();
    }

    int k;
    int sum;
    Queue<Integer> store;
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
