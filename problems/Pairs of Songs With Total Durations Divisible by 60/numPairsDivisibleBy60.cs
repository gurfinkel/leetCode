public class Solution {
    public int NumPairsDivisibleBy60(int[] time) {
        int result = 0;
        Dictionary<int, int> store = new Dictionary<int, int>();

        foreach (int song in time) {
            int mod = song % 60;

            if (0 == mod) {
                if (store.ContainsKey(0)) {
                    result += store[0];
                }
            } else {
                if (store.ContainsKey(60 - mod)) {
                    result += store[60 - mod];
                }
            }

            if (store.ContainsKey(mod)) {
                ++store[mod];
            } else {
                store.Add(mod, 1);
            }
        }

        return result;
    }
}
