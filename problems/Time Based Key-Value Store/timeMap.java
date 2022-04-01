class TimeMap {

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeSet<Node> ts = map.getOrDefault(key, new TreeSet<Node>((x1, x2) -> x1.timestamp - x2.timestamp));
        Node node = new Node(value, timestamp);
        ts.add(node);
        map.put(key, ts);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeSet<Node> ts = map.get(key);
        Node node = ts.floor(new Node("", timestamp));
        if (node == null) {
            return "";
        }
        return node.value;
    }

    class Node {
        String value;
        int timestamp;

        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, TreeSet<Node>> map;
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
