class RandomizedSet {

    public RandomizedSet() {
        idxToVal = new HashMap<>();
        valToIdx = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!valToIdx.containsKey(val)) {
            valToIdx.put(val, idxToVal.size());
            idxToVal.put(idxToVal.size(), val);

            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (valToIdx.containsKey(val)) {
            int currIdx = valToIdx.get(val);
            int lastIdx = valToIdx.size() - 1;
            int lastVal = idxToVal.get(lastIdx);

            idxToVal.put(currIdx, lastVal);
            valToIdx.put(lastVal, currIdx);
            idxToVal.remove(lastIdx);
            valToIdx.remove(val);

            return true;
        }

        return false;
    }

    public int getRandom() {
        return idxToVal.get(random.nextInt(valToIdx.size()));
    }

    private HashMap<Integer, Integer> idxToVal;
    private HashMap<Integer, Integer> valToIdx;
    private Random random;
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
