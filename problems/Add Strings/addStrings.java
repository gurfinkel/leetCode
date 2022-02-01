class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        while (0 < carry || 0 <= idx1 || 0 <= idx2) {
            int num = carry;
            num += (0 <= idx1) ? (num1.charAt(idx1--) - '0') : 0;
            num += (0 <= idx2) ? (num2.charAt(idx2--) - '0') : 0;

            sb.append(num%10);
            carry = num/10;
        }

        return sb.reverse().toString();
    }
}
