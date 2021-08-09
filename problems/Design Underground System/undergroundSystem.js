
var UndergroundSystem = function() {
    this.metroSystem = new MetroSystem();
};

/**
 * @param {number} id
 * @param {string} stationName
 * @param {number} t
 * @return {void}
 */
UndergroundSystem.prototype.checkIn = function(id, stationName, t) {
    this.metroSystem.checkIn(id, stationName, t);
};

/**
 * @param {number} id
 * @param {string} stationName
 * @param {number} t
 * @return {void}
 */
UndergroundSystem.prototype.checkOut = function(id, stationName, t) {
    this.metroSystem.checkOut(id, stationName, t);
};

/**
 * @param {string} startStation
 * @param {string} endStation
 * @return {number}
 */
UndergroundSystem.prototype.getAverageTime = function(startStation, endStation) {
    return this.metroSystem.getAverageTime(startStation, endStation);
};

class MetroSystem {
    constructor() {
        this.checkInStore = new Map();
        this.journeyStore = new Map();
    }

    checkIn(id, stationName, t) {
        this.checkInStore.set(id, [stationName, t]);
    }

    checkOut(id, stationName, t) {
        const [startStation, startTime] = this.checkInStore.get(id);
        const key = `${startStation}+${stationName}`;
        let totalTime = t - startTime;
        let totalCount = 1;

        if (this.journeyStore.has(key)) {
            const [time, count] = this.journeyStore.get(key);

            totalTime += time;
            totalCount += count;
        }

        this.journeyStore.set(key, [totalTime, totalCount]);
    }

    getAverageTime(startStation, endStation) {
        const key = `${startStation}+${endStation}`;
        const [totalTime, totalCount] = this.journeyStore.get(key);

        return totalTime / totalCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = new UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */
