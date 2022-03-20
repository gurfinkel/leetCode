/**
 * @param {number[]} tops
 * @param {number[]} bottoms
 * @return {number}
 */
var minDominoRotations = function(tops, bottoms) {
    const swaps = [0, 1, 0, 1];

    for (let i = 1; i in tops; ++i) {
        if (0 <= swaps[0] && tops[0] !== tops[i])
            if (tops[0] === bottoms[i]) ++swaps[0];
            else swaps[0] = -1;
        if (0 < swaps[1] && tops[0] !== bottoms[i])
            if (tops[0] === tops[i]) ++swaps[1];
            else swaps[1] = -1;
        if (0 <= swaps[2] && bottoms[0] !== bottoms[i])
            if (bottoms[0] === tops[i]) ++swaps[2];
            else swaps[2] = -1;
        if (0 < swaps[3] && bottoms[0] !== tops[i])
            if (bottoms[0] === bottoms[i]) ++swaps[3];
            else swaps[3] = -1;
        if (swaps.every(item => -1 === item))
            return -1;
    }

    return Math.min(...swaps.filter(item => 0 <= item));
};
