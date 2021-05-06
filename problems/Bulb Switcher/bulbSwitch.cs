public class Solution {
    public int BulbSwitch(int n) {
        if (1 >= n) {
            return n;
        }

        int result = 1;

        for (long idx = 2; n >= idx * idx; ++idx) {
            ++result;
        }

        return result;
    }
}
