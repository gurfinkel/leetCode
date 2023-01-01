/**
 * @param {number} n
 * @return {boolean}
 */
var confusingNumber = function(n) {
    const store = new Map([[0,0], [1,1], [6,9], [8,8], [9,6]]);
    const oldNumber = n;
    let newNumber = 0;

    while (n) {
        const digit = n % 10;

        if (store.has(digit)) {
            newNumber = 10 * newNumber + store.get(digit);
            n = ~~(n / 10);
        } else {
            return false;
        }
    }

    return oldNumber !== newNumber;
};
