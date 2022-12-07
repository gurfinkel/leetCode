class UndergroundSystem {

    public UndergroundSystem() {
        store = new HashMap<>();
        checkInStore = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInStore.put(id, stationName + "%" + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String[] items = checkInStore.get(id).split("%");
        String startStation = items[0];
        int startTime = Integer.parseInt(items[1]);
        String key = startStation + "%" + stationName;

        if (store.containsKey(key)) {
            String[] sumAndCount = store.get(key).split("%");
            int sum = Integer.parseInt(sumAndCount[0]);
            int count = Integer.parseInt(sumAndCount[1]);

            sum += t - startTime;
            ++count;

            store.put(key, "" + sum + "%" + count);
        } else {
            store.put(key, "" + (t - startTime) + "%" + 1);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "%" + endStation;
        String[] items = store.get(key).split("%");
        int sum = Integer.parseInt(items[0]);
        int count = Integer.parseInt(items[1]);

        return (double)sum / count;
    }

    private HashMap<String, String> store;
    private HashMap<Integer, String> checkInStore;
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
