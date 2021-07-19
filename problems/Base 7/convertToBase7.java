class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;

        if (0 > num) {
            num = -1 * num;
            isNegative = true;
        }

        while (7 <= num) {
            sb.append(num % 7);
            num /= 7;
        }

        sb.append(num);

        if (isNegative) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }
}
