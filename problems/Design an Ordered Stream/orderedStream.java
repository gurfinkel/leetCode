class OrderedStream {

    public OrderedStream(int n) {
        store = new String[1 + n];
        Arrays.fill(store, "%");
        idx = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();

        store[idKey] = value;

        while (store.length > idx && !"%".equals(store[idx])) {
            result.add(store[idx++]);
        }

        return result;
    }

    String[] store;
    int idx;
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
