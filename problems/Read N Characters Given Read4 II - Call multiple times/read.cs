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
        int res = 0;
        int globalIdx = 0;

        if (n == 0)
        {
            return res;
        }

        while (_buf4Idx < _buf4Count)
        {
            buf[globalIdx++] = _buf4[_buf4Idx++];
            n--;
            res++;
            if (n == 0)
            {
                return res;
            }
        }

        while (true)
        {
            _buf4Count = Read4(_buf4);
            for (_buf4Idx = 0; _buf4Idx < _buf4Count; _buf4Idx++)
            {
                buf[globalIdx++] = _buf4[_buf4Idx];
                n--;
                res++;
                if (n == 0)
                {
                    _buf4Idx++;
                    return res;
                }
            }

            if (_buf4Count < 4)
            {
                return res;
            }
        }
    }

    private readonly char[] _buf4 = new char[4];
    private int _buf4Idx = 0;
    private int _buf4Count = 0;
}
