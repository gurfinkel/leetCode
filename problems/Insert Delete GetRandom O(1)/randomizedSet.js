
var RandomizedSet = function() {
    this.mapIdxToVal = new Map();
    this.mapValToIdx = new Map();
};

/**
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function(val) {
    if (!this.mapValToIdx.has(val)) {
        this.mapValToIdx.set(val, this.mapValToIdx.size);
        this.mapIdxToVal.set(this.mapIdxToVal.size, val);

        return true;
    }

    return false;
};

/**
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function(val) {
    if (this.mapValToIdx.has(val)) {
        const currIdx = this.mapValToIdx.get(val);
        const lastIdx = this.mapIdxToVal.size - 1;
        const lastVal = this.mapIdxToVal.get(lastIdx);

        this.mapIdxToVal.set(currIdx, lastVal);
        this.mapValToIdx.set(lastVal, currIdx);
        this.mapIdxToVal.delete(lastIdx);
        this.mapValToIdx.delete(val);

        return true;
    }

    return false;
};

/**
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function() {
    return this.mapIdxToVal.get(Math.trunc(Math.random() * this.mapIdxToVal.size));
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
