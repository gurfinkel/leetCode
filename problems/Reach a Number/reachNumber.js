/**
 * @param {number} target
 * @return {number}
 */
var reachNumber = function(target) {
    target = Math.abs(target);

    let k = 0;

    while (0 < target) {
        target -= ++k;
    }

    return 0 === (1&target) ? k : 1 + k + (k % 2);
};
