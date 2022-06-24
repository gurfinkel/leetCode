class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        int max = 0;
        int idx = 0;

        for (int i = 0; target.length > i; ++i) {
            sum += target[i];

            if (target[i] > max) {
                max = target[i];
                idx = i;
            }
        }

        sum -= max;

        if (1 == sum || 1 == max) {
            return true;
        }

        if (max < sum || 0 == sum || 0 == max % sum) {
            return false;
        }

        max %= sum;
        target[idx] = max;

        return isPossible(target);
    }
}
