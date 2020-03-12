public class Solution {
    public int MinEatingSpeed(int[] piles, int H) {
        return Helper(1, piles.Max(), piles, H);
    }

    private int Helper(int min, int max, int[] piles, int h)
    {
        int res = int.MaxValue;
        int sum = 0;

        while (min < max)
        {
            int mid = min + (max - min) / 2;

            if (max - min == 1)
            {
                break;
            }

            sum = 0;
            foreach (var pile in piles)
            {
                sum += pile / mid;
                if (pile % mid != 0)
                {
                    sum++;
                }
            }

            if (sum <= h)
            {
                res = Math.Min(res, mid);
                max = mid;
                continue;
            }

            min = mid;
        }


        sum = 0;
        foreach (var pile in piles)
        {
            sum += pile / max;
            if (pile % max != 0)
            {
                sum++;
            }
        }

        if (sum <= h)
        {
            res = Math.Min(res, max);
        }


        sum = 0;
        foreach (var pile in piles)
        {
            sum += pile / min;
            if (pile % min != 0)
            {
                sum++;
            }
        }

        if (sum <= h)
        {
            res = Math.Min(res, min);
        }

        return res;
    }
}
