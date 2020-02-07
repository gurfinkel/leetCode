class MaxBinaryHeap {
    constructor () {
        this._baseArray = [];
    }

    _getLeftChildIndex(parentIndex) {
        return 2 * parentIndex + 1;
    }

    _getRightChildIndex(parentIndex) {
        return 2 * parentIndex + 2;
    }

    _getParentIndex(childIndex) {
        if (!childIndex) {
            return -1;
        }

        return (childIndex - 1) >> 1;
    }

    _swap(a, firstIndex, secondIndex) {
        [a[firstIndex], a[secondIndex]] = [a[secondIndex], a[firstIndex]];
    }

    getMin() {
        return this._baseArray[0];
    }

    getSize() {
        return this._baseArray.length;
    }

    insert(a) {
        this._baseArray.push(a);
        this.siftUp(this._baseArray, this._baseArray.length - 1);
    }

    extractRoot() {
        if (!this._baseArray.length) {
            return;
        }

        if (1 === this._baseArray.length) {
            return this._baseArray.shift();
        }

        this._swap(this._baseArray, 0, this._baseArray.length - 1);
        let item = this._baseArray.pop();

        this.siftDown(this._baseArray, 0);

        return item;
    }

    siftUp(a, childIndex) {
        let parentIndex = this._getParentIndex(childIndex);

        while (0 <= parentIndex) {
            if (a[childIndex] > a[parentIndex]) {
                this._swap(a, childIndex, parentIndex);
                childIndex = parentIndex;
            }

            parentIndex = this._getParentIndex(parentIndex);
        }
    }

    siftDown(a, parentIndex) {
        let leftChildIndex = this._getLeftChildIndex(parentIndex);
        let rightChildIndex = this._getRightChildIndex(parentIndex);

        while (a.length > leftChildIndex) {
            if (a.length > rightChildIndex) {
                if (a[leftChildIndex] > a[rightChildIndex] && a[leftChildIndex] > a[parentIndex]) {
                    this._swap(a, parentIndex, leftChildIndex);
                    parentIndex = leftChildIndex;
                } else if (a[rightChildIndex] > a[parentIndex]) {
                    this._swap(a, parentIndex, rightChildIndex);
                    parentIndex = rightChildIndex;
                } else {
                    return;
                }
            } else if (a[leftChildIndex] > a[parentIndex]) {
                this._swap(a, parentIndex, leftChildIndex);
                parentIndex = leftChildIndex;
            } else {
                return;
            }

            leftChildIndex = this._getLeftChildIndex(parentIndex);
            rightChildIndex = this._getRightChildIndex(parentIndex);
        }
    }
}

module.exports = MaxBinaryHeap;
