public class UndergroundSystem {
    private Dictionary<string, (int, int)> _tripsStore;
    private Dictionary<int, (string, int)> _checkinStore;

    public UndergroundSystem() {
        _tripsStore = new Dictionary<string, (int, int)>();
        _checkinStore = new Dictionary<int, (string, int)>();
    }

    public void CheckIn(int id, string stationName, int t) {
        _checkinStore.Add(id, (stationName, t));
    }

    public void CheckOut(int id, string stationName, int t) {
        var (startStation, time) = _checkinStore[id];
        var key = startStation + stationName;

        if (_tripsStore.ContainsKey(key)) {
            var (sum, count) = _tripsStore[key];
            _tripsStore[key] = (sum + t - time, 1 + count);
        } else {
            _tripsStore.Add(key, (t - time, 1));
        }

        _checkinStore.Remove(id);
    }

    public double GetAverageTime(string startStation, string endStation) {
        var key = startStation + endStation;
        var (sum, count) = _tripsStore[key];

        return (double)sum / count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.CheckIn(id,stationName,t);
 * obj.CheckOut(id,stationName,t);
 * double param_3 = obj.GetAverageTime(startStation,endStation);
 */