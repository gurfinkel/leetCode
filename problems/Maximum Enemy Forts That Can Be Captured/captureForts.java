class Solution {
    public int captureForts(int[] forts) {
        int result = 0;
        int n = forts.length;
        boolean startFlag = false;
        int counter = 0;

        for (int idx = 0; n > idx; ++idx) {
            if (1 == forts[idx]) {
                startFlag = true;
                counter = 0;
            } else if (-1 == forts[idx]) {
                result = Math.max(result, counter);
                startFlag = false;
                counter = 0;
            } else {
                if (startFlag) {
                    ++counter;
                }
            }
        }

        for (int idx = n - 1; 0 <= idx; --idx) {
            if (1 == forts[idx]) {
                startFlag = true;
                counter = 0;
            } else if (-1 == forts[idx]) {
                result = Math.max(result, counter);
                startFlag = false;
                counter = 0;
            } else {
                if (startFlag) {
                    ++counter;
                }
            }
        }

        return result;
    }
}
