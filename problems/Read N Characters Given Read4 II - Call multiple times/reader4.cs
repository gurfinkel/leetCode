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

        while (true) {
            while (_idx < _count && n > idx) {
                buf[idx++] = _buf[_idx++];
            }

            if (n == idx) {
                break;
            }

            _idx = 0;
            _count = Read4(_buf);

            if (0 == _count) {
                break;
            }
        }

        return idx;
    }

    private readonly char[] _buf = new char[4];
    private int _idx = 0;
    private int _count = 0;
}
