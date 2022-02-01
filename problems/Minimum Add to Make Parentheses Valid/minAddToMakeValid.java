class Solution {
    public int minAddToMakeValid(String s) {
        int openCounter = 0;
        int closeCounter = 0;

        for (char item : s.toCharArray()) {
            closeCounter += '(' == item ? 1 : -1;

            if (-1 == closeCounter) {
                ++openCounter;
                ++closeCounter;
            }
        }

        return openCounter + closeCounter;
    }
}
