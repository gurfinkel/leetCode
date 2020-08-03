public class Logger {

    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public bool ShouldPrintMessage(int timestamp, string message) {
        if (_store.ContainsKey(message)) {
            if (timestamp - _store[message] >= 10) {
                _store[message] = timestamp;
                return true;
            } else {
                return false;
            }
        } else {
            _store.Add(message, timestamp);
            return true;
        }
    }

    private Dictionary<string, int> _store = new Dictionary<string, int>();
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * bool param_1 = obj.ShouldPrintMessage(timestamp,message);
 */
