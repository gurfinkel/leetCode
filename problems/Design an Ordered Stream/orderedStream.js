/**
 * @param {number} n
 */
var OrderedStream = function(n) {
    this.store = Array(n);
    this.visited = new Set();
    this.idx = 0;
};

/**
 * @param {number} idKey
 * @param {string} value
 * @return {string[]}
 */
OrderedStream.prototype.insert = function(idKey, value) {
    const result = [];

    this.store[idKey - 1] = value;
    this.visited.add(idKey - 1);

    while (this.visited.has(this.idx)) {
        result.push(this.store[this.idx++]);
    }

    return result;
};

/**
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = new OrderedStream(n)
 * var param_1 = obj.insert(idKey,value)
 */
