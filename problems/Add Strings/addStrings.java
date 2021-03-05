class Solution {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int memory = 0;
        StringBuilder sb = new StringBuilder();

        while (0 <= idx1 || 0 <= idx2 || 0 != memory) {
            int digit = memory;

            if (0 <= idx1) {
                digit += num1.charAt(idx1--) - '0';
            }

            if (0 <= idx2) {
                digit += num2.charAt(idx2--) - '0';
            }

            sb.insert(0, digit % 10);
            memory = digit / 10;
        }

        return sb.toString();
    }
}
