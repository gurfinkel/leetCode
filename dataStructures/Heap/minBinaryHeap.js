class MinBinaryHeap {
    constructor () {
        this._data = [];
    }

    _swap(i, j) {
        [this._data[i], this._data[j]] = [this._data[j], this._data[i]];
    }

    getSize() {
        return this._data.length;
    }

    insert(a) {
        this._data.push(a);
        this.siftUp(this.getSize() - 1);
    }

    extractRoot() {
        const root = this._data.shift();

        if (this.getSize()) {
            this._data.unshift(this._data.pop());
            this.siftDown(0);
        }

        return root;
    }

    siftUp(i) {
        while (this._data[i] < this._data[((i - 1) >> 1)]) {
            this._swap(i, ((i - 1) >> 1));
            i = ((i - 1) >> 1);
        }
    }

    siftDown(i) {
        while (this.getSize() > (i << 1) + 1) {
            const left = (i << 1) + 1;
            const right = (i << 1) + 2;
            let j = left;

            if (this.getSize() > right && this._data[right] < this._data[left]) {
                j = right;
            }

            if (this._data[i] <= this._data[j]) {
                break;
            }

            this._swap(i, j);
            i = j;
        }
    }
}

module.exports = MinBinaryHeap;
