public class Solution {
    public int TitleToNumber(string columnTitle) {
        int total = 0;

        foreach(char c in columnTitle) {
            total *= 26;
            int val = c - 'A' + 1;
            total += val;
        }

        return total;
    }
}
