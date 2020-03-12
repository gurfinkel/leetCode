public class Solution {
    public int BulbSwitch(int n) {
        if (n <= 1)
        {
            return n;
        }

        int res = 1;

        for (long i = 2; i * i <= n; i++)
        {
            res++;
        }

        return res;
    }
}
