/**
 * @param {string} S
 * @param {number} K
 * @return {string}
 */
var licenseKeyFormatting = function(S, K) {
    const str = S.split('-').join('').toUpperCase();
    const n = str.length;
    const rem =  n % K;
    const result = [];

    let i = 0;
    let end = K;

    if (rem) {
        result.push(str.slice(0, rem));
        i = rem;
        end += rem;
    }

    while(n >= end) {
        result.push(str.slice(i, end));
        i += K;
        end += K;
    }

    return result.join('-');
};
