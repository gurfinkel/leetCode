class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;

        for(char character : S.toCharArray()) {
            if (0 != sbLength && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                ++sbLength;
            }
        }

        return sb.toString();
    }
}
