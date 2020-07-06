public class Solution {
    public int[] PrisonAfterNDays(int[] cells, int N) {
        Dictionary<int, int> store = new Dictionary<int, int>();
        bool isFastForwarded = false;

        while (0 < N--) {
            if (!isFastForwarded) {
                int stateBitmap = cellsToBitmap(cells);

                if (store.ContainsKey(stateBitmap)) {
                    N %= store[stateBitmap] - N;
                    isFastForwarded = true;
                } else {
                    store.Add(stateBitmap, N);
                }
            }

            cells = nextDay(cells);
        }

        return cells;
    }

    private int cellsToBitmap(int[] cells) {
        int stateBitmap = 0x0;

        foreach (int cell in cells) {
            stateBitmap <<= 1;
            stateBitmap = (stateBitmap | cell);
        }

        return stateBitmap;
    }

    private int[] nextDay(int[] cells) {
        int[] newCells = new int[cells.Length];

        newCells[0] = 0;

        for (int i = 1; cells.Length > 1 + i; ++i) {
            newCells[i] = (0 == (cells[i - 1]^cells[i + 1])) ? 1 : 0;
        }

        newCells[cells.Length - 1] = 0;

        return newCells;
    }
}
