class Solution {
    public boolean validUtf8(int[] data) {
        if (null == data || 0 == data.length) {
            return false;
        }

        int expectedByteCount = 0;

        for (int num : data) {
            if (0 == expectedByteCount) {
                if (0b0 == num >> 7) {
                    continue;
                } else if (0b110 == num >> 5) {
                    expectedByteCount = 1;
                } else if (0b1110 == num >> 4) {
                    expectedByteCount = 2;
                } else if (0b11110 == num >> 3) {
                    expectedByteCount = 3;
                } else {
                    return false;
                }
            } else {
                if (0b10 != num >> 6) {
                    return false;
                }

                --expectedByteCount;
            }
        }

        return 0 == expectedByteCount;
    }
}
