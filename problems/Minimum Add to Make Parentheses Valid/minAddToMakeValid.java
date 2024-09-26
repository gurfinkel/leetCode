class Solution {
    public int minAddToMakeValid(String s) {
        int openCountToBalance = 0;
        int closeCountToBalance = 0;

        for (char symbol : s.toCharArray()) {
            if ('(' == symbol) {
                ++closeCountToBalance;
            } else {
                --closeCountToBalance;
            }

            if (-1 == closeCountToBalance) {
                ++openCountToBalance;
                closeCountToBalance = 0;
            }
        }

        return openCountToBalance + closeCountToBalance;
    }
}
