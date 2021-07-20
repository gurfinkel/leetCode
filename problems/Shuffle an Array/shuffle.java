class Solution {

    public Solution(int[] nums) {
        _random = new Random();
        _store = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return _store;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = _store.clone();

        for (int idx = 0; _store.length > idx; ++idx) {
            swap(result, idx, getRandom(idx, _store.length));
        }

        return result;
    }

    private Random _random;
    private int[] _store;

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int getRandom(int min, int max) {
        return min + _random.nextInt(max - min);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
