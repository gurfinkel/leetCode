class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char symbol : s.toCharArray()) {
            if (!sb.isEmpty() && symbol == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(symbol);
            }
        }

        return sb.toString();
    }
}
