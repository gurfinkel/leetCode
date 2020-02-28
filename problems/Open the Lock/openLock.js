/**
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */
var openLock = function(deadends, target) {
    const queue = [];
    const dead = new Set(deadends);
    const start = '0000';
    let level = 0;

    if (dead.has(start)) {
        return -1;
    }

    dead.add(start);
    queue.push(start);

    while (queue.length) {
        let count = queue.length;

        for (let i = 0; count > i; ++i) {
            const current = queue.shift();

            if (target === current) {
                return level;
            }

            for (let j = 0; current.length > j; ++j) {
                const str1 = `${current.substring(0, j)}${(+current[j] + 1) % 10}${current.substring(j+1)}`;
                const str2 = `${current.substring(0, j)}${(+current[j] + 9) % 10}${current.substring(j+1)}`;

                if (!dead.has(str1)) {
                    dead.add(str1); queue.push(str1);
                }
                if (!dead.has(str2)) {
                    dead.add(str2); queue.push(str2);
                }
            }
        }
        ++level;
    }

    return -1;
};
