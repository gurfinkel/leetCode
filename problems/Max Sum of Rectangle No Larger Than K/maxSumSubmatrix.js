/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var maxSumSubmatrix = function(matrix, k) {
    const lowerBound = function(arr, target) {
        let left = 0;
        let right = arr.length;

        while (left < right) {
            const mid = (left + right) >> 1;

            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    };

    const findMax = function(nums, target) {
        const arr = [0];
        let sum = 0;
        let max = -Infinity;

        for (const num of nums) {
            sum += num;
            const index = lowerBound(arr, sum - target);

            max = Math.max(max, index in arr ? sum - arr[index] : -Infinity);
            arr.splice(lowerBound(arr, sum), 0, sum);
        }

        return max;
    };

    const getMaxSumLessK = function(nums, target) {
        const n = nums.length;
        const prefixSums = Array(1 + n).fill(0);
        let result = -Infinity;

        nums.reduce((acc,item,idx)=>{acc+=item;prefixSums[1+idx]=acc;return acc;},0);

        for (let i = 0; n > i; ++i) {
            for (let j = i + 1; n >= j; ++j) {
                if (prefixSums[j]-prefixSums[i] <= target) {
                    result = Math.max(result, prefixSums[j]-prefixSums[i]);
                }
            }
        }

        return result;
    };

    const [rows, cols] = [matrix, matrix[0]].map(arr => arr.length);
    const prefixSums = Array(rows).fill(0);
    let max = -Infinity;

    for (let leftCol = 0; cols > leftCol; ++leftCol) {
        for (let rightCol = leftCol; cols > rightCol; ++rightCol) {
            for (let row = 0; rows > row; ++row) {
                prefixSums[row] = (rightCol === leftCol ? 0 : prefixSums[row]) + matrix[row][rightCol];
            }
            max = Math.max(max, getMaxSumLessK(prefixSums, k));
        }
    }

    return max;
};
