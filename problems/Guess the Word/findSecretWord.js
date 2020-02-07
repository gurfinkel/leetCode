/**
 * // This is the master's API interface.
 * // You should not implement it, or speculate about its implementation
 * function Master() {
 *
 *     @param {string[]} wordlist
 *     @param {Master} master
 *     @return {integer}
 *     this.guess = function(word) {
 *         ...
 *     };
 * };
 */
/**
 * @param {string[]} wordlist
 * @param {Master} master
 * @return {void}
 */
var findSecretWord = function(wordlist, master) {
    const aCode = 'a'.charCodeAt(0);
    const guesses = 10;
    const wordLength = 6;

    const getSimilarity = function(a, b) {
        return [...a].reduce((result, item, index) => result += +(item === b[index]), 0);
    };

    const getFrequencyOfCharacters = function() {
        const result = Array(6).fill([]).map(_ => Array(26).fill(0));

        for (const w of wordlist) {
            for (let i = 0; i < 6; ++i) {
                ++result[i][w.charCodeAt(i) - aCode];
            }
        }

        return result;
    };

    const getWordToTry = function(frequencyOfCharacters) {
        let best = 0;

        for (const w of wordlist) {
            let score = 0;
            for (let i = 0; i < 6; ++i) {
                score += frequencyOfCharacters[i][w.charCodeAt(i) - aCode];
            }
            if (score > best) {
                result = w;
                best = score;
            }
        }

        return result;
    };

    for (let t = 0, x = 0; guesses > t && wordLength > x; ++t) {
        const word = getWordToTry(getFrequencyOfCharacters());
        const goodWords = [];

        x = master.guess(word);

        for (const w of wordlist) {
            if (x === getSimilarity(word, w)) {
                goodWords.push(w);
            }
        }

        wordlist = goodWords;
    }
}
