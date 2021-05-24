class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                sb.append(Character.toLowerCase(letter));
            } else {
                sb.append(letter);
            }
        }

        return sb.toString();
    }
}
