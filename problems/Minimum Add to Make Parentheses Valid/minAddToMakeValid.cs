public class Solution {
    public int MinAddToMakeValid(string S) {
        var ans = 0;
        var bal = 0;

        foreach (var item in S) {
            bal += item == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}
