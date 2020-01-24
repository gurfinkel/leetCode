/**
 * @param {number} N
 * @return {number}
 */
var confusingNumberII = function(N) {
    const confusingNumber = function(n) {
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

    const helper = function(n, cur) {
        if (confusingNumber(cur)) {
            ++result;
        }

        for (const key of store.keys()) {
            const validNum = cur * 10 + key;

            if (n >= validNum && validNum) {
                helper(n, validNum);
            }
        }
    };

    const store = new Map([[0,0], [1,1], [6,9], [8,8], [9,6]]);
    let result = 0;

    helper(N, 0);

    return result;
};
