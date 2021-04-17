class Solution {
    public int minAddToMakeValid(String S) {
        int result = 0;
        int balanced = 0;

        for (char item : S.toCharArray()) {
            balanced += '(' == item ? 1 : -1;

            if (-1 == balanced) {
                ++result;
                ++balanced;
            }
        }

        return result + balanced;
    }
}
