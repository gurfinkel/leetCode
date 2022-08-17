class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        int idx = 0;

        for (char symbol : number.toCharArray()) {
            if (Character.isDigit(symbol)) {
                sb.append(symbol);
                ++n;
            }
        }

        while (sb.length() > idx) {
            if (4 < n) {
                n -= 3;
                sb.insert(3 + idx, '-');
                idx += 3;
            } else if (4 == n) {
                n -= 2;
                sb.insert(2 + idx, '-');
                idx += 2;
            }
            ++idx;
        }

        return sb.toString();
    }
}
