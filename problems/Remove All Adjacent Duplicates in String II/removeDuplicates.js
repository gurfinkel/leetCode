/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var removeDuplicates = function(s, k) {
    const sb = s.split('');
    const store = [];

    for (let idx = 0; sb.length > idx; ++idx) {
        if (0 === idx || sb[idx - 1] !== sb[idx]) {
            store.push(1);
        } else {
            const count = 1 + store.pop();

            if (k === count) {
                sb.splice(1 + idx - k, k);
                idx -= k;
            } else {
                store.push(count);
            }
        }
    }

    return sb.join('');
};
