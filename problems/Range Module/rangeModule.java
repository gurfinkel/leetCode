class RangeModule {

    public TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        int start = left, end = right;
        Integer floorKey = map.floorKey(left);
        if (floorKey != null && map.get(floorKey) >= left) {
            start = Math.min(start, floorKey);
            end = Math.max(end, map.get(floorKey));
            map.remove(floorKey);
        }
        Integer higherKey = map.higherKey(left);
        while (higherKey != null && higherKey <= right) {
            end = Math.max(end, map.get(higherKey));
            map.remove(higherKey);
            higherKey = map.higherKey(left);
        }
        map.put(start, end);
    }

    public boolean queryRange(int left, int right) {
        Integer floorKey = map.floorKey(left);
        if (floorKey == null)
            return false;
        return map.get(floorKey) >= right;
    }

    public void removeRange(int left, int right) {
        int start = left, end = right;
        Integer floorKey = map.floorKey(left);
        if (floorKey != null && map.get(floorKey) > left) {
            if (map.get(floorKey) <= right)
                map.put(floorKey, left);
            else {
                int temp = map.get(floorKey);
                map.put(floorKey, left);
                map.put(right, temp);
            }
        }
        Integer higherKey = map.higherKey(left);
        while (higherKey != null && higherKey < right) {
            if (map.get(higherKey) <= right)
                map.remove(higherKey);
            else {
                int temp = map.get(higherKey);
                map.remove(higherKey);
                map.put(right, temp);
            }
            higherKey = map.higherKey(left);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
