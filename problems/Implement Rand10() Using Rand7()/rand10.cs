/**
 * The Rand7() API is already defined in the parent class SolBase.
 * public int Rand7();
 * @return a random integer in the range 1 to 7
 */
public class Solution : SolBase {
    public int Rand10() {
        int col = Rand7();
        int row = Rand7();
        int idx = col + 7 * (row - 1);

        while (40 < idx) {
            col = Rand7();
            row = Rand7();
            idx = col + 7 * (row - 1);
        }

        return 1 + (idx - 1) % 10;
    }
}
