class DataStream {

    public DataStream(int value, int k) {
        item = value;
        size = k;
        store = new LinkedList<>();
    }

    public boolean consec(int num) {
        store.add(num);

        if (size < store.size()) {
            int oldNum = store.poll();

            if (item == oldNum) {
                --count;
            }
        }

        if (item == num) {
            ++count;
        }

        return size == count;
    }

    private Queue<Integer> store;
    private int size;
    private int item;
    private int count;
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
