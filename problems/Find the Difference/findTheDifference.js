/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
    const letterFrequencies = Array(26).fill(0);
    const aCode = 'a'.charCodeAt();
    
    for (let idx = 0; t.length > idx; ++idx) {
        ++letterFrequencies[t.charCodeAt(idx) - aCode];
    }
    
    for (let idx = 0; s.length > idx; ++idx) {
        --letterFrequencies[s.charCodeAt(idx) - aCode];
    }
    
    for (let idx = 0; letterFrequencies.length > idx; ++idx) {
        if (0 !== letterFrequencies[idx]) {
            return String.fromCharCode(aCode + idx);
        }
    }
};
