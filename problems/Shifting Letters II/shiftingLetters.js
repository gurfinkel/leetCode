/**
 * @param {string} s
 * @param {number[][]} shifts
 * @return {string}
 */
var shiftingLetters = function(s, shifts) {
    const n = s.length;
    const aCode = 'a'.charCodeAt();
    const finalState = Array(n).fill(0);
    const letters = s.split('');
    let state = 0;

    for (const shift of shifts) {
        const direction = 1 === shift[2] ? 1 : -1;
        finalState[shift[0]] += direction;
        finalState[1 + shift[1]] += (-1)*direction;
    }

    for (let idx = 0; n > idx; ++idx) {
        state += finalState[idx];
        state %= 26;

        letters[idx] = String.fromCharCode(aCode + ((letters[idx].charCodeAt(0) + 26 - aCode + state) % 26));
    }

    return letters.join('');
};
