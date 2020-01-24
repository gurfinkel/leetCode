/**
 * @param {number[]} sweetness
 * @param {number} K
 * @return {number}
 */
var maximizeSweetness = function(sweetness, K) {
    let left = 1;
    let right = sweetness.reduce((acc, item) => acc + item);

    while (left < right) {
        let mid = ~~((left + right + 1) >> 1);
        let sum = 0;
        let pieces = 0;

        for (const item of sweetness) {
            sum += item;
            if (sum >= mid) {
                ++pieces;
                sum = 0;
                if (K < pieces) {
                    break;
                }
            }
        }

        if (K < pieces) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    return left;
};
