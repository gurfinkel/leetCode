/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var minDominoRotations = function(A, B) {
    const swaps = [0, 1, 0, 1];

    for (let i = 1; i in A; ++i) {
        if (0 <= swaps[0] && A[0] !== A[i])
            if (A[0] === B[i]) ++swaps[0];
            else swaps[0] = -1;
        if (0 < swaps[1] && A[0] !== B[i])
            if (A[0] === A[i]) ++swaps[1];
            else swaps[1] = -1;
        if (0 <= swaps[2] && B[0] !== B[i])
            if (B[0] === A[i]) ++swaps[2];
            else swaps[2] = -1;
        if (0 < swaps[3] && B[0] !== A[i])
            if (B[0] === B[i]) ++swaps[3];
            else swaps[3] = -1;
        if (swaps.every(item => -1 === item))
            return -1;
    }

    return Math.min(...swaps.filter(item => 0 <= item));
};
