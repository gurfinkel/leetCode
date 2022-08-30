/**
 * @param {string[]} transactions
 * @return {string[]}
 */
var invalidTransactions = function(transactions) {
    const result = [];
    const nameToTransactions = new Map();
    const store = new Set();
    const duplicates = new Map();

    for (const item of transactions) {
        const transaction = item.split(',');

        if (!duplicates.has(item)) {
            duplicates.set(item, 0);
        }
        duplicates.set(item, 1 + duplicates.get(item));

        if (1000 < parseInt(transaction[2])) {
            store.add(item);
        }

        if (nameToTransactions.has(transaction[0])) {
            const list = nameToTransactions.get(transaction[0]);

            for (let i = 0; list.length > i; ++i) {
                const sameNameTransaction = list[i].split(',');

                if (sameNameTransaction[3] !== transaction[3] &&
                    60 >= Math.abs(parseInt(sameNameTransaction[1]) - parseInt(transaction[1]))) {
                    store.add(list[i]);
                    store.add(item);
                }
            }

            nameToTransactions.get(transaction[0]).push(item);
        } else {
            nameToTransactions.set(transaction[0], [item]);
        }
    }

    for (const item of store) {
        for (let idx = 0; duplicates.get(item) > idx; ++idx) {
            result.push(item);
        }
    }

    return result;
};
