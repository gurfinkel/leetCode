/**
 * The Read4 API is defined in the parent class Reader4.
 *     int Read4(char[] buf);
 */
public class Solution : Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int Read(char[] buf, int n) {
        var idx = 0;
        var store = new char[4];

        while (n > idx) {
            var count = Read4(store);
            if (0 == count) break;
            for (var i = 0; count > i && n > idx; ++i) {
                buf[idx++] = store[i];
            }
        }

        return idx;
    }
}
