class Solution {
    public boolean checkPowersOfThree(int n) {
        int maxPower = (int)(Math.log(n) / Math.log(3));
        int[] powersOfThree = new int[maxPower + 1];

        powersOfThree[0] = 1;

        for (int idx = 1; maxPower >= idx; ++idx){
            powersOfThree[idx] = 3 * powersOfThree[idx - 1];
        }

        for(int idx = maxPower; 0 <= idx; --idx){
            if (n >= powersOfThree[idx]) {
                 n -= powersOfThree[idx];
            }
        }

        return 0 == n;
    }
}
