public class Solution {
    public int[] PrisonAfterNDays(int[] cells, int N) {
        Dictionary<int, int> store = new Dictionary<int, int>();
        int step = 0;
        bool flag = true;

        store.Add(cellsToBitmap(cells), step);

        while (step++ < N) {
            cells = getNextState(cells);

            if (flag) {
                int bitMap = cellsToBitmap(cells);

                if (store.ContainsKey(bitMap)) {
                    N = (N - store[bitMap]) % (step - store[bitMap]);
                    step = 0;
                    flag = false;
                } else {
                    store.Add(bitMap, step);
                }
            }
        }

        return cells;
    }

    private int cellsToBitmap(int[] cells) {
        int bitMap = 0;

        foreach (int cell in cells) {
            bitMap <<= 1;
            bitMap |= cell;
        }

        return bitMap;
    }

    private int[] getNextState(int[] cells) {
        int n = cells.Length;
        int[] nextState = new int[n];

        for (int idx = 1; n - 1 > idx; ++idx) {
            nextState[idx] = (0 == (cells[idx - 1] ^ cells[idx + 1])) ? 1 : 0;
        }

        return nextState;
    }
}
