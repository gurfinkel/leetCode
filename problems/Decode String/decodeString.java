class Solution {
    public String decodeString(String s) {
        Stack<Integer> counters = new Stack<>();
        Stack<StringBuilder> store = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char symbol : s.toCharArray()) {
            if (Character.isDigit(symbol)) {
                num = 10 * num + (symbol - '0');
            } else if ('[' == symbol) {
                counters.push(num);
                store.push(sb);
                sb = new StringBuilder();
                num = 0;
            } else if (']' == symbol) {
                StringBuilder decodedSb = store.pop();

                for (int count = counters.pop(); 0 < count; --count) {
                    decodedSb.append(sb);
                }
                sb = decodedSb;
            } else {
                sb.append(symbol);
            }
        }

        return sb.toString();
    }
}
