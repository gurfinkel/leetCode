class Solution {
    public boolean isPalindrome(int x) {
        if (0 > x) {
            return false;
        }

        List<Integer> digits = getDigits(x);

        return isValidPalindrome(digits);
    }

    List<Integer> getDigits(int num) {
        List<Integer> result = new ArrayList<>();

        while (0 != num) {
            result.add(num%10);
            num/=10;
        }

        return result;
    }

    boolean isValidPalindrome(List<Integer> symbols) {
        int left = 0;
        int right = symbols.size() - 1;

        while (left < right) {
            if (symbols.get(left++) != symbols.get(right--)) {
                return false;
            }
        }

        return true;
    }
}
