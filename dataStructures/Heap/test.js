const assert = require('assert');

const MaxBinaryHeap = require('./maxBinaryHeap');
const MinBinaryHeap = require('./minBinaryHeap');

function runHeapSortTests() {
    const ascHeapSort = function(a) {
        const minBinaryHeap = new MinBinaryHeap();

        while (a.length) {
            minBinaryHeap.insert(a.pop());
        }

        while (minBinaryHeap.getSize()) {
            a.push(minBinaryHeap.extractRoot());
        }
    };

    const descHeapSort = function(a) {
        const maxBinaryHeap = new MaxBinaryHeap();

        while (a.length) {
            maxBinaryHeap.insert(a.pop());
        }

        while (maxBinaryHeap.getSize()) {
            a.push(maxBinaryHeap.extractRoot());
        }
    };

    const getRandomSequence = function(size, modulo) {
        const result = [];

        for (let index = 0; size > index; ++index) {
            result.push(~~(Math.random() * 10 % modulo));
        }

        return result;
    };

    const ascTestHeapSort = function(testSequence, properAnswer) {
        let tempArray = testSequence.slice();
        ascHeapSort(testSequence);

        assert.deepEqual(
            properAnswer,
            testSequence,
            `"HeapSortError: Input: ${tempArray}; Proper answer: ${properAnswer}; Your answer: ${testSequence}`
        );
    };

    const descTestHeapSort = function(testSequence, properAnswer) {
        let tempArray = testSequence.slice();
        descHeapSort(testSequence);

        assert.deepEqual(
            properAnswer,
            testSequence,
            `"HeapSortError: Input: ${tempArray}; Proper answer: ${properAnswer}; Your answer: ${testSequence}`
        );
    };

    const mergeSort = function(sequence, comparer = (a, b) => +a < +b) {
        if (!sequence || !sequence.length || 1 === sequence.length) {
            return sequence;
        }

        const merge = function(a, b) {
            if (!a.length) {
                return b;
            }

            if (!b.length) {
                return a;
            }

            if (comparer(a[0], b[0])) {
                return [a[0], ...merge(a.slice(1), b)];
            } else {
                return [b[0], ...merge(a, b.slice(1))];
            }
        };

        const middle = sequence.length >> 1;
        const leftPart = sequence.slice(0, middle);
        const rightPart = sequence.slice(middle);

        return merge(mergeSort(leftPart, comparer), mergeSort(rightPart, comparer));
    };

    const runStressTest = function(maxSize = 10, maxModulo = 10, maxAttempt = 1000) {
        for (let size = 0; maxSize >= size; ++size) {
            console.log("Size: " + size);
            for (let modulo = 1; maxModulo >= modulo; ++modulo) {
                console.log("Modulo: " + modulo);
                for (let attempt = 0; maxAttempt > attempt; ++attempt) {
                    const testSequence = getRandomSequence(size, modulo);

                    const ascAnswer = mergeSort(testSequence);
                    const descAnswer = mergeSort(testSequence, (a, b) => +a > +b);

                    ascTestHeapSort(testSequence.slice(), ascAnswer);
                    descTestHeapSort(testSequence.slice(), descAnswer);
                }
            }
        }

        console.log("Passed stress test!");
    };

    ascTestHeapSort([], []);
    ascTestHeapSort([1], [1]);
    ascTestHeapSort([2,1], [1,2]);
    ascTestHeapSort([0,1,0], [0,0,1]);
    ascTestHeapSort([4,5,1,3,2], [1,2,3,4,5]);
    ascTestHeapSort([1,99,2,88,3,77,4,66,5,55,6,44,7,33,8,22,9,11], [1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99]);

    descTestHeapSort([], []);
    descTestHeapSort([1], [1]);
    descTestHeapSort([1,2], [2,1]);
    descTestHeapSort([0,1,0], [1,0,0]);
    descTestHeapSort([4,5,1,3,2], [5,4,3,2,1]);
    descTestHeapSort([1,99,2,88,3,77,4,66,5,55,6,44,7,33,8,22,9,11], [99,88,77,66,55,44,33,22,11,9,8,7,6,5,4,3,2,1]);

    runStressTest(50, 10, 10);
}

runHeapSortTests();
