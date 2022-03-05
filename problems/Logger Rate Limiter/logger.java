class Logger {

    public Logger() {
        store = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (store.containsKey(message)) {
            if (10 > timestamp - store.get(message)) {
                return false;
            } else {
                store.put(message, timestamp);
                return true;
            }
        } else {
            store.put(message, timestamp);
            return true;
        }
    }

    HashMap<String, Integer> store;
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
