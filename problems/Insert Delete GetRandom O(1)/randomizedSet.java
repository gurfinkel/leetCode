class RandomizedSet {

    public RandomizedSet() {
        mapIdxToVal = new HashMap<>();
        mapValToIdx = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!mapValToIdx.containsKey(val)) {
            mapValToIdx.put(val, mapValToIdx.size());
            mapIdxToVal.put(mapIdxToVal.size(), val);

            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (mapValToIdx.containsKey(val)) {
            int currIdx = mapValToIdx.get(val);
            int lastIdx = mapIdxToVal.size() - 1;
            int lastVal = mapIdxToVal.get(lastIdx);

            mapIdxToVal.put(currIdx, lastVal);
            mapValToIdx.put(lastVal, currIdx);
            mapIdxToVal.remove(lastIdx);
            mapValToIdx.remove(val);

            return true;
        }

        return false;
    }

    public int getRandom() {
        return mapIdxToVal.get(random.nextInt(mapIdxToVal.size()));
    }

    private HashMap<Integer, Integer> mapIdxToVal;
    private HashMap<Integer, Integer> mapValToIdx;
    private Random random;
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
