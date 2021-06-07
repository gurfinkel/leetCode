class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        StringBuilder sb = new StringBuilder();

        for (int i = len1 - 1; 0 <= i; --i) {
            for (int j = len2 - 1; 0 <= j; --j) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = multiply + result[1 + i + j];

                result[1 + i + j] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        for (int digit : result) {
            if (!(0 == digit && 0 == sb.length())) {
                sb.append(digit);
            }
        }

        return 0 == sb.length() ? "0" : sb.toString();
    }
}
