/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let result = 0;
    const MAX_VALUE = Math.pow(2, 31) - 1;
    const MIN_VALUE = Math.pow(-2, 31);

    while (x) {
        const digit = x % 10;
        x = Math.trunc(x/10);

        if (Math.trunc(MAX_VALUE/10) < result ||
            (Math.trunc(MAX_VALUE/10) === result && digit > 7)) {
            return 0;
        }

        if (Math.trunc(MIN_VALUE/10) > result ||
            (Math.trunc(MIN_VALUE/10) === result && digit < -8)) {
            return 0;
        }

        result *= 10;
        result += digit;
    }

    return result;
};
